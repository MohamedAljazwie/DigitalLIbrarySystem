-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>BI_MAILS</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">DigitalLibreary</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>BI_MAILS</name>
--         <identifier class="java.math.BigDecimal">16802</identifier>
--         <schemaName>DIGITALLIBRARY</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
trigger "BI_MAILS"  
  before insert on "MAILS"              
  for each row 
begin  
    select "LMSMAILSID".nextval into :NEW.MAIL_ID from dual;
end;
/
