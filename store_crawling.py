from selenium.webdriver.common.by import By
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import csv

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


def storeNamePrint(page):
    time.sleep(0.2)

    html = driver.page_source
    soup = BeautifulSoup(html, 'html.parser')

    store_lists = soup.select('.placelist > .PlaceItem')
    list = []

    for store in store_lists:
        temp = []
        name = store.select('.head_item > .tit_name > .link_name')[0].text
        degree = store.select('.rating > .score > .num')[0].text
        addr = store.select('.info_item > .addr')[0].text.splitlines()[1]  # 도로명주소 
        tel = store.select('.info_item > .contact > .phone')[0].text

        print(name, degree, addr, tel, '-')

        temp.append(name)
        temp.append(degree)
        temp.append(addr)

        list.append(temp)

    if page == 1:
        f = open('store_list_1.csv', 'w', encoding='utf-8-sig', newline='')
        writercsv = csv.writer(f)
        header = ['name', 'degree', 'address', 'tel']
        writercsv.writerow(header)

        for i in list:
            writercsv.writerow(i)
    else:
        f = open('store_list_1.csv', 'a', encoding='utf-8-sig', newline='')
        writercsv = csv.writer(f)

        for i in list:
            writercsv.writerow(i)


# 페이지 리스트만큼 크롤링하기 
storeNamePrint(1)
try:
    # 장소 더보기 버튼 누르기 
    btn = driver.find_element(By.CSS_SELECTOR, '.more')   
    driver.execute_script("arguments[0].click();", btn)

    for i in range(2, 6):
        # 페이지 넘기기
        xPath = '//*[@id="info.search.page.no' + str(i) + '"]'
        driver.find_element(By.XPATH, xPath).send_keys(Keys.ENTER)
        time.sleep(1)

        storeNamePrint(i)
except:
    print('ERROR!')

print('**크롤링 완료**')
