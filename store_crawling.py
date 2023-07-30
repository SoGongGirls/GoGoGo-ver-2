from selenium.webdriver.common.by import By
from urllib3.util.retry import Retry
from requests.adapters import HTTPAdapter
from bs4 import BeautifulSoup
from selenium import webdriver
import re
from selenium.webdriver.common.keys import Keys
import time
import requests
import json

url = 'https://map.kakao.com/'
driver = webdriver.Chrome()  # 드라이버 경로
# driver = webdriver.Chrome('./chromedriver',chrome_options=options) # 크롬창 숨기기
driver.get(url)

searchloc = input('찾고 싶은 음식 종류 : ')
#filename = input('파일 이름 영어로 치기 : ')

# 음식점 입력 후 찾기 버튼 클릭 
search_area = driver.find_element(By.XPATH, '//*[@id="search.keyword.query"]')   # 검색창
search_area.send_keys(searchloc)
driver.find_element(By.XPATH, '//*[@id="search.keyword.submit"]').send_keys(Keys.ENTER)
time.sleep(2)

# 장소 버튼 클릭 
driver.find_element(By.XPATH, '//*[@id="info.main.options"]/li[2]/a').send_keys(Keys.ENTER)


def storeNamePrint():
    time.sleep(0.2)

    html = driver.page_source
    soup = BeautifulSoup(html, 'html.parser')

    store_lists = soup.select('.placelist > .PlaceItem')

    for store in store_lists:
        temp = []
        name = store.select('.head_item > .tit_name > .link_name')[0].text
        degree = store.select('.rating > .score > .num')[0].text
        addr = store.select('.info_item > .addr')[0].text.splitlines()[1]
        tel = store.select('.info_item > .contact > .phone')[0].text

        print(name, degree, addr, tel, '-')

        temp.append(name)
        temp.append(degree)
        temp.append(addr)

        list.append(temp)

    # json 파일로 저장
    with open('store_data_1.json', 'w', encoding='utf-8') as f:
        json.dump(list, f, indent=4, ensure_ascii=False)
    
    return len(store_lists)


# 페이지 리스트만큼 크롤링하기 
page = 1   # 현재 크롤링하는 페이지가 전체에서 몇 번째 페이지인지 
page2 = 0   # 1~5번째 중 몇 번째인지 

for _ in range(0, 5):
    # 페이지 넘어가며 출력 
    try:
        page2 += 1
        print('**', page, '**')

        driver.find_element(By.XPATH, f'//*[@id="info.search.page.no{page2}"]').send_keys(Keys.ENTER)
        size = storeNamePrint()

        # 한 페이지에 장소 개수가 15개 미만이라면 해당 페이지는 마지막 페이지
        if len(size) < 15:
            break
		
        # 다음 버튼을 누를 수 없다면 마지막 페이지
        if not driver.find_element(By.XPATH, '//*[@id="info.search.page.next"]').is_enabled():
            break

        # 다섯번째 페이지까지 왔다면 다음 버튼을 누르고 page2 = 0으로 초기화
        if page2 % 5 == 0:
            driver.find_element(By.XPATH, '//*[@id="info.search.page.next"]').send_keys(Keys.ENTER)
            page2 = 0

        page += 1
    
    except:
        print('ERROR!')
        break

print('**크롤링 완료**')
