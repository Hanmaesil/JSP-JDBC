1. 회원가입한 정보를 저장할 수 있는 'web_member'테이블을 만드시오.
   컬럼명 : m_email / m_pw / m_tel / m_address
   
create table web_member(
m_email varchar(50),
m_pw varchar(50) not null,
m_tel varchar(50) not null,
m_address varchar(50) not null,
constraint m_email_web_member_pk primary key(m_email)
)

select * from web_member

drop table web_message 

create table web_message(
m_num number,
m_sendName varchar(50) not null,
m_receiveEmail varchar(50) not null,
m_content varchar(200) not null,
m_sendDate date not null,
constraint m_num_web_member_pk primary key(m_num)
)

select * from web_message

create sequence num_seq
increment by 1 start with 1
-- https://m.blog.naver.com/opgj123/221322082219  시퀀스 생성시 참고할 것--
insert into web_message values(num_seq.nextval,'test','asdf@naver.com','테스트 입니다2',sysdate)












