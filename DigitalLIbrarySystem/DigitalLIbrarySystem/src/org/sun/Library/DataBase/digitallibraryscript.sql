--
-- Create Schema Script 
--   Database Version   : 10.2.0.1.0 
--   TOAD Version       : 9.0.1.8 
--   DB Connect String  : XE 
--   Schema             : DIGITALLIBRARY 
--   Script Created by  : DIGITALLIBRARY 
--   Script Created at  : 22/12/2016 10:21:30 � 
--   Physical Location  :  
--   Notes              :  
--

-- Object Counts: 
--   Indexes: 30        Columns: 36         
--   Sequences: 11 
--   Tables: 18         Columns: 78         Constraints: 92     
--   Triggers: 11 


CREATE SEQUENCE LMSFINEID
  START WITH 10014
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  ORDER;


CREATE SEQUENCE LMSIDDUEWSBOOKID
  START WITH 1051
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  ORDER;


CREATE SEQUENCE LMSRETURNBOOKID
  START WITH 1049
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  ORDER;


CREATE SEQUENCE LMSLOGINID
  START WITH 101
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  ORDER;


CREATE SEQUENCE LMSADDRESSID
  START WITH 100
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  ORDER;


CREATE SEQUENCE LMSPUBLISHERID
  START WITH 106
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  ORDER;


CREATE SEQUENCE LMSAUTHORID
  START WITH 132
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  ORDER;


CREATE SEQUENCE LMSSTUDENTID
  START WITH 1102
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  ORDER;


CREATE SEQUENCE LMSBOOKID
  START WITH 1121
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  ORDER;


CREATE SEQUENCE LMSCATEGORYID
  START WITH 140
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  ORDER;


CREATE SEQUENCE LMSMAILSID
  START WITH 100
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  ORDER;


CREATE TABLE FINE
(
  FINE_ID      NUMBER CONSTRAINT FINE_FINEID_NK NOT NULL,
  RETURN_ID    NUMBER,
  FINE_DATE    VARCHAR2(50 BYTE) CONSTRAINT FINE_FINEDATE_NK NOT NULL,
  COST         VARCHAR2(10 BYTE) CONSTRAINT FINE_COST_NK NOT NULL,
  TOTAL_COST   VARCHAR2(10 BYTE) CONSTRAINT FINE_MODE_PAY_NK NOT NULL,
  MODE_OF_PAY  VARCHAR2(30 BYTE) CONSTRAINT FINE_REMARK_NK NOT NULL,
  REMARK       VARCHAR2(4000 BYTE)
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE MAILS
(
  MAIL_ID     NUMBER CONSTRAINT MAILS_MAIL_ID_NK NOT NULL,
  STUDENT_ID  NUMBER CONSTRAINT MAILS_STUDENT_ID_NK NOT NULL,
  TITLE       VARCHAR2(100 BYTE) CONSTRAINT MAILS_TITLE_NK NOT NULL,
  CONTENT     VARCHAR2(4000 BYTE) CONSTRAINT MAILS_MESSAGE_NK NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE BOOK_PUBLISHER
(
  BOOK_ID       NUMBER CONSTRAINT BOOK_PUBLISHER_BOOKID_NK NOT NULL,
  PUBLISHER_ID  NUMBER CONSTRAINT BOOK_PUBLISHER_AUTHID_NK NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE BOOK_AUTHOR
(
  BOOK_ID    NUMBER CONSTRAINT BOOK_AUTHOR_BOOKID_NK NOT NULL,
  AUTHOR_ID  NUMBER CONSTRAINT BOOK_AUTHOR_AUTHID_NK NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE CATEGORY
(
  CATEGORY_ID     NUMBER CONSTRAINT CATEGORY_CATID_NK NOT NULL,
  CATEGORY_NAME   VARCHAR2(100 BYTE) CONSTRAINT CATEGORY_CATNAME_NK NOT NULL,
  DESCRIPTION     VARCHAR2(4000 BYTE),
  SUPER_CATEGORY  NUMBER
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE BOOK
(
  BOOK_ID          NUMBER CONSTRAINT BOOK_BOOKID_NK NOT NULL,
  BOOK_ISBN        VARCHAR2(50 BYTE) CONSTRAINT BOOK_BOOKISBN_NK NOT NULL,
  BOOK_TITLE       VARCHAR2(200 BYTE) CONSTRAINT BOOK_BOOK_TITLE_NK NOT NULL,
  SUBJECT          VARCHAR2(200 BYTE) CONSTRAINT BOOK_SUBJECT_NK NOT NULL,
  PRICE            VARCHAR2(20 BYTE) CONSTRAINT BOOK_PRICE_NK NOT NULL,
  CATEGORY_ID      NUMBER CONSTRAINT BOOK_CATEGORYID_NK NOT NULL,
  PUBLISH_DATE     VARCHAR2(50 BYTE) CONSTRAINT BOOK_PUBLISHDATE_NK NOT NULL,
  QUANTITY         NUMBER CONSTRAINT BOOK_QUANTITY_NK NOT NULL,
  AVAILABLE_BOOKS  NUMBER CONSTRAINT BOOK_AVAILABILITY_NK NOT NULL,
  BORROWED_BOOKS   NUMBER CONSTRAINT BOOK BORROWED_NK NOT NULL,
  REGISTERED_DATE  VARCHAR2(50 BYTE)            DEFAULT TO_CHAR(SYSDATE,'dd-MONTH-yyyy') CONSTRAINT BOOK_REGISTERED_DATE_NK NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE STUDENT_PHONE
(
  STUDENT_ID    NUMBER CONSTRAINT STUDENT_PHONE_ID_NK NOT NULL,
  PHONE_NUMBER  NUMBER CONSTRAINT STUDENT_PHONE_NUMBER_NK NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE STUDENT
(
  STUDENT_ID          NUMBER CONSTRAINT STUDENT_STID_NK NOT NULL,
  STUDENT_NATIONALID  NUMBER CONSTRAINT STUDENT_STNATIONALID_NK NOT NULL,
  STUDENT_NAME        VARCHAR2(100 BYTE) CONSTRAINT STUDENT_STNAME_NK NOT NULL,
  STUDENT_EMAIL       VARCHAR2(100 BYTE) CONSTRAINT STUDENT_STEMAIL_NK NOT NULL,
  STUDENT_ADDRESS     VARCHAR2(400 BYTE),
  USER_NAME           VARCHAR2(100 BYTE) CONSTRAINT STUDENT_USER_NAME_NK NOT NULL,
  PASSWORD            VARCHAR2(100 BYTE) CONSTRAINT STUDENT_PASSWORD_NK NOT NULL,
  QUESTION            VARCHAR2(400 BYTE)        NOT NULL,
  ANSWER              VARCHAR2(400 BYTE)        NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE AUTHOR_PHONE
(
  AUTHOR_ID     NUMBER CONSTRAINT AUTHOR_PHONE_ID_NK NOT NULL,
  PHONE_NUMBER  NUMBER CONSTRAINT AUTHOR_PHONE_NUMBER_NK NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE AUTHOR
(
  AUTHOR_ID       NUMBER CONSTRAINT AUTHOR_AUTHLISID_NK NOT NULL,
  AUTHOR_NAME     VARCHAR2(100 BYTE) CONSTRAINT AUTHOR_AUTHNAME_NK NOT NULL,
  AUTHOR_EMAIL    VARCHAR2(100 BYTE) CONSTRAINT AUTHOR_AUTHEMAIL_NK NOT NULL,
  AUTHOR_ADDRESS  VARCHAR2(400 BYTE)
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE PUBLISHER_PHONE
(
  PUBLISHER_ID  NUMBER CONSTRAINT PUBLISHER_PHONE_ID_NK NOT NULL,
  PHONE_NUMBER  NUMBER CONSTRAINT PUBLISHER_PHONE_NUMBER_NK NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE PUBLISHER
(
  PUBLISH_ID         NUMBER CONSTRAINT PUBLISHER_PUBLISID_NK NOT NULL,
  PUBLISHER_NAME     VARCHAR2(100 BYTE) CONSTRAINT PUBLISHER_PUBNAME_NK NOT NULL,
  PUBLISHER_EMAIL    VARCHAR2(100 BYTE) CONSTRAINT PUBLISHER_PUBEMAIL_NK NOT NULL,
  PUBLISHER_ADDRESS  VARCHAR2(400 BYTE)
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE ADDRESS
(
  ID       NUMBER CONSTRAINT ADDRESS_ID_NK      NOT NULL,
  CITY     VARCHAR2(50 BYTE),
  COUNTRY  VARCHAR2(50 BYTE)
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE TEST
(
  ID        VARCHAR2(15 BYTE)                   NOT NULL,
  PASSWORD  VARCHAR2(4000 BYTE)                 NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE QUALIFICATIONS
(
  AUTHOR_ID      NUMBER CONSTRAINT QUALIFICATIONS_ID_NK NOT NULL,
  QUALIFICATION  VARCHAR2(100 BYTE)
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE LMSLOGIN
(
  ID        NUMBER                              NOT NULL,
  USERNAME  VARCHAR2(100 BYTE)                  NOT NULL,
  PASSWORD  VARCHAR2(100 BYTE)                  NOT NULL,
  ROLE      VARCHAR2(50 BYTE) CONSTRAINT LMSLOGIN_ROLE_NK NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE RETURN_BOOK
(
  RETURN_ID      NUMBER CONSTRAINT RETURN_BOOK_ISSID_NK NOT NULL,
  STUDENT_ID     NUMBER CONSTRAINT RETURN_BOOK_STID_NK NOT NULL,
  BOOK_ID        NUMBER CONSTRAINT RETURN_BOOK_BOOKID_NK NOT NULL,
  ISSUE_DATE     VARCHAR2(50 BYTE) CONSTRAINT RETURN_BOOK_RETDATE_NK NOT NULL,
  RETURN_DATE    VARCHAR2(50 BYTE),
  RETURNED_DATE  VARCHAR2(50 BYTE)              DEFAULT '07/27/2016' CONSTRAINT RETURN_BOOK_RETURNEDDATE_NK NOT NULL,
  NOTES          VARCHAR2(4000 BYTE)            DEFAULT 'no Notes'
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE ISSUES_BOOK
(
  ISSUE_ID     NUMBER CONSTRAINT ISSUES_BOOK_ISSID_NK NOT NULL,
  STUDENT_ID   NUMBER CONSTRAINT ISSUES_BOOK_STID_NK NOT NULL,
  BOOK_ID      NUMBER CONSTRAINT ISSUES_BOOK_BOOKID_NK NOT NULL,
  ISSUE_DATE   VARCHAR2(50 BYTE) CONSTRAINT ISUES_BOOK_ISSDATE_NK NOT NULL,
  RETURN_DATE  VARCHAR2(50 BYTE)                DEFAULT '07/25/2016' CONSTRAINT ISSUE_BOOK_RETURNDATE_NK NOT NULL,
  STATUS       VARCHAR2(20 BYTE)                DEFAULT 'issued' CONSTRAINT ISSUE_BOOK_STATUS_NK NOT NULL,
  NOTES        VARCHAR2(4000 BYTE)              DEFAULT 'no Notes'
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE UNIQUE INDEX FINE_ID_PK ON FINE
(FINE_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX MAILS_ID_PK ON MAILS
(MAIL_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX STUDENT_USER_NAME_UQ ON STUDENT
(USER_NAME)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX BOOK_PUBLISHER_PK ON BOOK_PUBLISHER
(BOOK_ID, PUBLISHER_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX BOOK_AUTHOR_PK ON BOOK_AUTHOR
(BOOK_ID, AUTHOR_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX CATEGORY_ID_PK ON CATEGORY
(CATEGORY_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX BOOK_ISBN_UK ON BOOK
(BOOK_ISBN)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX BOOK_ID_PK ON BOOK
(BOOK_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX STUDENT_PHONE_NUMBER_UK ON STUDENT_PHONE
(PHONE_NUMBER)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX STUDENT_PHONE_PK ON STUDENT_PHONE
(STUDENT_ID, PHONE_NUMBER)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX STUDENT_STNATIONALID_UK ON STUDENT
(STUDENT_NATIONALID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX STUDENT_STEMAIL_UK ON STUDENT
(STUDENT_EMAIL)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX STUDENT_STID_PK ON STUDENT
(STUDENT_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX AUTHOR_PHONE_NUMBER_UK ON AUTHOR_PHONE
(PHONE_NUMBER)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX AUTHOR_PHONE_PK ON AUTHOR_PHONE
(AUTHOR_ID, PHONE_NUMBER)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX AUTHOR_AUTHEMAIL_UK ON AUTHOR
(AUTHOR_EMAIL)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX AUTHOR_AUTHID_PK ON AUTHOR
(AUTHOR_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX PUBLISHER_PHONE_NUMBER_UK ON PUBLISHER_PHONE
(PHONE_NUMBER)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX PUBLISHER_PHONE_PK ON PUBLISHER_PHONE
(PUBLISHER_ID, PHONE_NUMBER)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX PUBLISHER_PUBEMAIL_UK ON PUBLISHER
(PUBLISHER_EMAIL)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX PUBLISHER_PUBID_PK ON PUBLISHER
(PUBLISH_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX ADDRESS_ID_PK ON ADDRESS
(ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX CATEGORY_CATNAME_UK ON CATEGORY
(CATEGORY_NAME)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX TEST_CON ON TEST
(ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX QUALIFICATIONS_PK ON QUALIFICATIONS
(AUTHOR_ID, QUALIFICATION)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX FINE_RETURNBOOK_ID_NK ON FINE
(RETURN_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX LMSLOGIN_USERNAME_UK ON LMSLOGIN
(USERNAME)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX LMSLOGIN_PK ON LMSLOGIN
(ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX RETURN_BOOK_ID_PK ON RETURN_BOOK
(RETURN_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX ISSUES_BOOK_ID_PK ON ISSUES_BOOK
(ISSUE_ID)
LOGGING
NOPARALLEL;


CREATE OR REPLACE TRIGGER "BI_LMSLOGIN"   
  before insert on "LMSLOGIN"               
  for each row
begin   
    select "LMSLOGINID".nextval into :NEW.ID from dual; 
end;
/
SHOW ERRORS;



CREATE OR REPLACE TRIGGER "BI_ADDRESS"  
  before insert on "ADDRESS"              
  for each row
begin  
    select "LMSADDRESSID".nextval into :NEW.ID from dual;
end;
/
SHOW ERRORS;



CREATE OR REPLACE TRIGGER "BI_PUBLISHER"  
  before insert on "PUBLISHER"              
  for each row
begin  
    select "LMSPUBLISHERID".nextval into :NEW.PUBLISH_ID from dual;
end;
/
SHOW ERRORS;



CREATE OR REPLACE TRIGGER "BI_CATEGORY"  
  before insert on "CATEGORY"              
  for each row
begin  
    select "LMSCATEGORYID".nextval into :NEW.CATEGORY_ID from dual;
end;
/
SHOW ERRORS;



CREATE OR REPLACE TRIGGER "BI_STUDENT"  
  before insert on "STUDENT"              
  for each row
begin  
    select "LMSSTUDENTID".nextval into :NEW.STUDENT_ID from dual;
end;
/
SHOW ERRORS;



CREATE OR REPLACE TRIGGER "BI_AUTHOR"  
  before insert on "AUTHOR"              
  for each row
begin  
    select "LMSAUTHORID".nextval into :NEW.AUTHOR_ID from dual;
end;
/
SHOW ERRORS;



CREATE OR REPLACE TRIGGER "BI_MAILS"  
  before insert on "MAILS"              
  for each row
begin  
    select "LMSMAILSID".nextval into :NEW.MAIL_ID from dual;
end;
/
SHOW ERRORS;



CREATE OR REPLACE TRIGGER "BI_FINE"  
  before insert on "FINE"              
  for each row
begin  
    select "LMSFINEID".nextval into :NEW.FINE_ID from dual;
end;
/
SHOW ERRORS;



CREATE OR REPLACE TRIGGER "BI_ISSUESBOOK"  
  before insert on "ISSUES_BOOK"              
  for each row
begin  
    select "LMSIDDUEWSBOOKID".nextval into :NEW.ISSUE_ID from dual;
end;
/
SHOW ERRORS;



CREATE OR REPLACE TRIGGER "BI_RETURNBOOK"  
  before insert on "RETURN_BOOK"              
  for each row
begin  
    select "LMSRETURNBOOKID".nextval into :NEW.RETURN_ID from dual;
end;
/
SHOW ERRORS;



CREATE OR REPLACE TRIGGER "BI_BOOK"  
  before insert on "BOOK"              
  for each row
begin  
    select "LMSBOOKID".nextval into :NEW.BOOK_ID from dual;
end;
/
SHOW ERRORS;



ALTER TABLE FINE ADD (
  CONSTRAINT FINE_ID_PK
 PRIMARY KEY
 (FINE_ID));

ALTER TABLE MAILS ADD (
  CONSTRAINT MAILS_ID_PK
 PRIMARY KEY
 (MAIL_ID));

ALTER TABLE BOOK_PUBLISHER ADD (
  CONSTRAINT BOOK_PUBLISHER_PK
 PRIMARY KEY
 (BOOK_ID, PUBLISHER_ID));

ALTER TABLE BOOK_AUTHOR ADD (
  CONSTRAINT BOOK_AUTHOR_PK
 PRIMARY KEY
 (BOOK_ID, AUTHOR_ID));

ALTER TABLE CATEGORY ADD (
  CONSTRAINT CATEGORY_ID_PK
 PRIMARY KEY
 (CATEGORY_ID));

ALTER TABLE BOOK ADD (
  CONSTRAINT BOOK_ID_PK
 PRIMARY KEY
 (BOOK_ID));

ALTER TABLE STUDENT_PHONE ADD (
  CONSTRAINT STUDENT_PHONE_PK
 PRIMARY KEY
 (STUDENT_ID, PHONE_NUMBER));

ALTER TABLE STUDENT ADD (
  CONSTRAINT STUDENT_STID_PK
 PRIMARY KEY
 (STUDENT_ID));

ALTER TABLE AUTHOR_PHONE ADD (
  CONSTRAINT AUTHOR_PHONE_PK
 PRIMARY KEY
 (AUTHOR_ID, PHONE_NUMBER));

ALTER TABLE AUTHOR ADD (
  CONSTRAINT AUTHOR_AUTHID_PK
 PRIMARY KEY
 (AUTHOR_ID));

ALTER TABLE PUBLISHER_PHONE ADD (
  CONSTRAINT PUBLISHER_PHONE_PK
 PRIMARY KEY
 (PUBLISHER_ID, PHONE_NUMBER));

ALTER TABLE PUBLISHER ADD (
  CONSTRAINT PUBLISHER_PUBID_PK
 PRIMARY KEY
 (PUBLISH_ID));

ALTER TABLE ADDRESS ADD (
  CONSTRAINT ADDRESS_ID_PK
 PRIMARY KEY
 (ID));

ALTER TABLE TEST ADD (
  CONSTRAINT TEST_CON
 PRIMARY KEY
 (ID));

ALTER TABLE QUALIFICATIONS ADD (
  CONSTRAINT QUALIFICATIONS_PK
 PRIMARY KEY
 (AUTHOR_ID, QUALIFICATION));

ALTER TABLE LMSLOGIN ADD (
  CONSTRAINT LMSLOGIN_PK
 PRIMARY KEY
 (ID));

ALTER TABLE RETURN_BOOK ADD (
  CONSTRAINT RETURN_BOOK_ID_PK
 PRIMARY KEY
 (RETURN_ID));

ALTER TABLE ISSUES_BOOK ADD (
  CONSTRAINT ISSUES_BOOK_ID_PK
 PRIMARY KEY
 (ISSUE_ID));

ALTER TABLE FINE ADD (
  CONSTRAINT FINE_RETURNBOOK_ID_FK 
 FOREIGN KEY (RETURN_ID) 
 REFERENCES 
    ON DELETE CASCADE);

ALTER TABLE MAILS ADD (
  CONSTRAINT MAILS_STUDENT_ID_FK 
 FOREIGN KEY (STUDENT_ID) 
 REFERENCES 
    ON DELETE CASCADE);

ALTER TABLE BOOK_PUBLISHER ADD (
  CONSTRAINT BOOK_PUBLISHER_PUBLISHER_ID_FK 
 FOREIGN KEY (PUBLISHER_ID) 
 REFERENCES 
    ON DELETE CASCADE,
  CONSTRAINT BOOK_PUBLISHER_BOOK_ID_FK 
 FOREIGN KEY (BOOK_ID) 
 REFERENCES 
    ON DELETE CASCADE);

ALTER TABLE BOOK_AUTHOR ADD (
  CONSTRAINT BOOK_AUTHOR_AUTHOR_ID_FK 
 FOREIGN KEY (AUTHOR_ID) 
 REFERENCES 
    ON DELETE CASCADE,
  CONSTRAINT BOOK_AUTHOR_BOOK_ID_FK 
 FOREIGN KEY (BOOK_ID) 
 REFERENCES 
    ON DELETE CASCADE);

ALTER TABLE CATEGORY ADD (
  CONSTRAINT CATEGORY_ID_FK 
 FOREIGN KEY (SUPER_CATEGORY) 
 REFERENCES);

ALTER TABLE BOOK ADD (
  CONSTRAINT BOOK_CATID_FK 
 FOREIGN KEY (CATEGORY_ID) 
 REFERENCES);

ALTER TABLE STUDENT_PHONE ADD (
  CONSTRAINT STUDENT_PHONE_ID_FK 
 FOREIGN KEY (STUDENT_ID) 
 REFERENCES 
    ON DELETE CASCADE);

ALTER TABLE AUTHOR_PHONE ADD (
  CONSTRAINT AUTHOR_PHONE_ID_FK 
 FOREIGN KEY (AUTHOR_ID) 
 REFERENCES 
    ON DELETE CASCADE);

ALTER TABLE PUBLISHER_PHONE ADD (
  CONSTRAINT PUBLISHER_PHONE_ID_FK 
 FOREIGN KEY (PUBLISHER_ID) 
 REFERENCES 
    ON DELETE CASCADE);

ALTER TABLE QUALIFICATIONS ADD (
  CONSTRAINT QUALIFICATIONS_ID_FK 
 FOREIGN KEY (AUTHOR_ID) 
 REFERENCES 
    ON DELETE CASCADE);

ALTER TABLE RETURN_BOOK ADD (
  CONSTRAINT RETURN_BOOK_BOOK_ID_FK 
 FOREIGN KEY (BOOK_ID) 
 REFERENCES 
    ON DELETE CASCADE,
  CONSTRAINT RETURN_BOOK_STUDENT_ID_FK 
 FOREIGN KEY (STUDENT_ID) 
 REFERENCES 
    ON DELETE CASCADE);

ALTER TABLE ISSUES_BOOK ADD (
  CONSTRAINT ISSUES_BOOK_BOOK_ID_FK 
 FOREIGN KEY (BOOK_ID) 
 REFERENCES 
    ON DELETE CASCADE,
  CONSTRAINT ISSUES_BOOK_STUDENT_ID_FK 
 FOREIGN KEY (STUDENT_ID) 
 REFERENCES 
    ON DELETE CASCADE);

