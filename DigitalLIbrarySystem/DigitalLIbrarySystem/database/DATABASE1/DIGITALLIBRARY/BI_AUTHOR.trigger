-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>BI_AUTHOR</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">DigitalLibreary</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>BI_AUTHOR</name>
--         <identifier class="java.math.BigDecimal">16786</identifier>
--         <schemaName>DIGITALLIBRARY</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
trigger "BI_AUTHOR"  
  before insert on "AUTHOR"              
  for each row 
begin  
    select "LMSAUTHORID".nextval into :NEW.AUTHOR_ID from dual;
end;
/
