-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>BI_CATEGORY</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">DigitalLibreary</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>BI_CATEGORY</name>
--         <identifier class="java.math.BigDecimal">16792</identifier>
--         <schemaName>DIGITALLIBRARY</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
trigger "BI_CATEGORY"  
  before insert on "CATEGORY"              
  for each row 
begin  
    select "LMSCATEGORYID".nextval into :NEW.CATEGORY_ID from dual;
end;
/
