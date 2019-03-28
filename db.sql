
--데이터 보기
select * from restaurant;

--데이터 추가
insert into restaurant(num, name, kind, reco_menu, menu_link) values (restaurant_num_seq.nextval,'고봉식','한식','닭도리탕','https://store.naver.com/restaurants/detail?id=326286770&tab=menu#_tab');

--링크 업데이트
update restaurant set menu_link='https://store.naver.com/restaurants/detail?id=17920617&tab=menu#_tab' where num=62;

--데이터 삭제
delete from restaurant where num=1;
