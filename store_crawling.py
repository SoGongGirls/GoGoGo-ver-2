import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from time import sleep
from bs4 import BeautifulSoup
import re
import json

# --크롬창을 숨기고 실행-- driver에 options를 추가해주면된다
# options = webdriver.ChromeOptions()
# options.add_argument('headless')

url = 'https://map.naver.com/v5/search'
driver = webdriver.Chrome()  # 드라이버 경로
# driver = webdriver.Chrome('./chromedriver',chrome_options=options) # 크롬창 숨기기
driver.get(url)
key_word = '서울 삼겹살 맛집'  # 검색어


# css 찾을때 까지 10초대기
def time_wait(num, code):
    try:
        wait = WebDriverWait(driver, num).until(
            EC.presence_of_element_located((By.CSS_SELECTOR, code)))
    except:
        print(code, '태그를 찾지 못하였습니다.')
        driver.quit()
    return wait

# css를 찾을때 까지 10초 대기
time_wait(10, 'div.input_box > input.input_search')


# 검색창 찾기
search = driver.find_element(By.CSS_SELECTOR, 'div.input_box > input.input_search')
search.send_keys(key_word)  # 검색어 입력
search.send_keys(Keys.ENTER)  # 엔터버튼 누르기

res = driver.page_source  # 페이지 소스 가져오기
soup = BeautifulSoup(res, 'html.parser')  # html 파싱하여  가져온다

sleep(1)


# frame 변경 메소드
def switch_frame(frame):
    driver.switch_to.default_content()  # frame 초기화
    driver.switch_to.frame(frame)  # frame 변경


# 페이지 다운
def page_down(num):
    body = driver.find_element(By.CSS_SELECTOR, 'body')
    body.click()
    for i in range(num):
        body.send_keys(Keys.PAGE_DOWN)

# frame 변경
switch_frame('searchIframe')
page_down(40)
sleep(5)


# 매장 리스트
store_list = driver.find_elements(By.CSS_SELECTOR, '.UEzoS')
# 페이지 리스트
next_btn = driver.find_elements(By.CSS_SELECTOR, '.CHC5F > a')

# dictionary 생성
store_dict = {'매장정보': []}
# 시작시간
start = time.time()
print('[크롤링 시작...]')

# 크롤링 (페이지 리스트 만큼)
for btn in range(len(next_btn))[1:]:  # next_btn[0] = 이전 페이지 버튼 무시 -> [1]부터 시작
    for data in range(len(store_list)):  # 매장 리스트 만큼
        page = driver.find_elements(By.CSS_SELECTOR, '.sub ng-star-inserted')
        page[data].click()
        sleep(2)
        try:
            # 상세 페이지로 이동
            switch_frame('entryIframe')
            time_wait(5, '.BXtr_')

            # 스크롤을 맨밑으로 1초간격으로 내린다.
            for down in range(3):
                sleep(1)
                driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")

            # -----매장명 가져오기-----
            store_name = driver.find_element(By.CSS_SELECTOR, '.Fc1rA').text
            print(store_rating)

            # -----평점-----
            try:
                store_rating_list = driver.find_element(By.CSS_SELECTOR, '.PXMot').text
                store_rating = re.sub('별점', '', store_rating_list).replace('\n', '')  # 별점이라는 단어 제거
            except:
                pass
            print(store_rating)

            # -----주소(위치)-----
            try:
                store_addr_list = driver.find_elements(By.CSS_SELECTOR, '.vV_z_')
                for i in store_addr_list:
                    store_addr = i.find_element(By.CSS_SELECTOR, '.LDgIH').text
            except:
                pass
            print(store_addr)

            # -----전화번호 가져오기-----
            try:
                store_tel = driver.find_element(By.CSS_SELECTOR, '.xlx7Q').text
            except:
                pass
            print(store_tel)

            # -----썸네일 사진 주소-----
            try:
                thumb_list = driver.find_element(By.CSS_SELECTOR, '.K0PDV') \
                    .value_of_css_property('background-image')  # css 속성명을 찾는다
                store_thumb = re.sub('url|"|\)|\(', '', thumb_list)  # url , (" ") 제거
            except:
                pass
            print(store_thumb)

            # ---- dict에 데이터 집어넣기----
            dict_temp = {
                'name': store_name,
                'tel': store_tel,
                'star': store_rating,
                'addr': store_addr,
                'thumb': store_thumb
            }

            store_dict['매장정보'].append(dict_temp)

            print(f'{store_name} ...완료')
            switch_frame('searchIframe')
            sleep(1)

        except:
            print('ERROR!' * 3)

    # 다음 페이지 버튼
    if page[-1]:  # 마지막 매장일 경우 다음버튼 클릭
        next_btn[-1].click()
        sleep(2)
    else:
        print('페이지 인식 못함')
        break

print('[데이터 수집 완료]\n소요 시간 :', time.time() - start)
driver.quit()  # 작업이 끝나면 창을닫는다.

# json 파일로 저장
with open('store_data_1.json', 'w', encoding='utf-8') as f:
    json.dump(store_dict, f, indent=4, ensure_ascii=False)
