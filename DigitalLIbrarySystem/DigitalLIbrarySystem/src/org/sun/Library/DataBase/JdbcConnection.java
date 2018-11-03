package org.sun.Library.DataBase;

//import Classes_Package.Customer;
//
//import com.jscape.inet.email.EmailMessage;
//
//import com.jscape.inet.smtpssl.SmtpSsl;

import java.sql.*;

import java.lang.System;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JdbcConnection {

    private Connection connection;
    private static int Get_Id, getID = 0;
    private ResultSet resultSet;
    private static String insertData = "";
    private static String Header;
    //    String select = "Select max(Conection_id) from Table_Conection";
    //    String Update = "Update Table_Conection"
    //            + "set User_Name=''";
    private static int executeQ = 0;
    private PreparedStatement preparedStatement;
    private Statement statement;

    private static String Sql;
    private static JdbcConnection jdbcConnection;

    private JdbcConnection() {

    }

    public void addConnection(Connection connection) {
        this.connection = connection;
        try {
            this.connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("     \n \tYou Have An Error IN   \n\n" + "the Error Code  is     " + e.getErrorCode() +
                               "\n\n" + "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            e.printStackTrace();

        }
    }

    public static synchronized JdbcConnection getInstance() {
        if (jdbcConnection == null) {
            synchronized (JdbcConnection.class) {
                if (jdbcConnection == null)
                    jdbcConnection = new JdbcConnection();
            }
        }
        return jdbcConnection;
    }

    private void Driverload() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver  Loaded");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Not Loaded");
        }
    }

    public Connection connectToDataBase() {
        Driverload();
        String URL = "jdbc:oracle:thin:@localhost:1521:xe";


        try {
            connection = DriverManager.getConnection(URL, "digitallibrary", "digitallibrary");
            System.out.print("Connection Scussess");

        } catch (SQLException e) {
            System.out.println("You Have An Error IN   \n\n" + "the Error Code  is     " + e.getErrorCode() + "\n\n" +
                               "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            return null;
        }
        return connection;
    }


    public Connection getConnection() {

        return this.connection;
    }

    public void closConection() {
        try {
            getConnection().close();
            System.out.println(" THe Connction Close Sucessfully");
        } catch (SQLException e) {
            System.out.println("You Have An Error IN   \n\n" + "the Error Code  is     " + e.getErrorCode() + "\n\n" +
                               "the Message   is     " + e.getMessage() + "\n\n" + e.toString());

        }
    }

    public ResultSet Insert(String tableName, String[] fieldes, Object[] attribute) {
        String colmunNames = "";
        if (fieldes.length == 0)
            colmunNames = "";
        else {
            colmunNames = " ( ";
            for (int val = 0; val < fieldes.length; val++) {
                colmunNames += fieldes[val] + ",";
            }

            colmunNames = colmunNames.substring(0, colmunNames.length() - 1) + ")";
        }
        insertData = " INSERT INTO  " + tableName + colmunNames + " VALUES(";
        // Get_Max_ID(connection, tableName, "CUSTOMER_ID") + " ,";
        for (int val = 0; val < attribute.length; val++) {
            insertData += "  ?,";
        }
        insertData = insertData.substring(0, insertData.length() - 1) + " ) ";

        try {
            int generatedColumns[] = { 1 };
            preparedStatement = connection.prepareStatement(insertData, generatedColumns);
            insertData = "";
            for (int set = 1; set <= attribute.length; set++) {
                preparedStatement.setObject(set, attribute[set - 1]);
            }
            executeQ = preparedStatement.executeUpdate();
            if (executeQ > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                System.out.println("executeQ  " + executeQ);

                return resultSet;
            } else {
                System.out.println("executeQ  " + executeQ);
                return null;
            }
        } catch (SQLException e) {
            System.out.println("You Have An Error IN Insert Method   in JdbcConnection \n\n" +
                               "the Error Code  is     " + e.getErrorCode() + "\n\n" + "the Message   is     " +
                               e.getMessage() + "\n\n" + e.toString() + "\n\n");
            e.printStackTrace();


            return null;
        }

    }

    public ResultSet search(String tableName, String by, Object For) {
        if (tableName == null || tableName.equals(""))
            return null;

        String[] condition = null;
        String[] fields = { "*" };
        if (by != null && by.equals(""))
            condition = new String[] { by };

        For = "%" + For + "%";
        Object[] attribute = { For };
        String[] op = { " LIKE " };
        String[] sep = { " AND " };
        resultSet = check(tableName, fields, condition, attribute, op, sep);
        return resultSet;
    }

    public ResultSet search(String tableName, String[] by, Object[] For) {
        if (tableName == null || tableName.equals(""))
            return null;
        String[] fields = { "*" };
        String[] condition = by;
        Object[] attribute = new Object[For.length];
        for (int i = 0; i < For.length; i++)
            attribute[i] = "%" + For[i] + "%";

        String[] op = { " LIKE " };
        String[] sep = { " AND " };
        resultSet = check(tableName, fields, condition, attribute, op, sep);
        return resultSet;
    }

    public ResultSet search(String tableName, String[] by, Object[] For, String[] op, String[] sep) {
        if (tableName == null || tableName.equals(""))
            return null;
        String[] fields = { "*" };
        String[] condition = by;
        Object[] attribute = new Object[For.length];
        for (int i = 0; i < For.length; i++)
            attribute[i] = "%" + For[i] + "%";

        resultSet = check(tableName, fields, condition, attribute, op, sep);
        return resultSet;
    }

    public ResultSet search(String[] tableNames, String[] fieldes, String[] by, List<Object> For) {
        try {
            if (tableNames == null || tableNames.length == 0 || tableNames.equals(""))
                return null;

            if (fieldes == null || fieldes.length == 0 || fieldes.equals(""))
                fieldes = new String[] { "*" };
            String header = selectHeader(" SELECT ", fieldes, " , ") + " FROM ";
            header = selectHeader(header, tableNames, " NATURAL JOIN ");
            if (by != null && by.length > 0) {
                header += " WHERE ";
                String[] op = new String[by.length];
                String[] sep = new String[by.length];
                for (int i = 0; i < by.length; i++) {
                    op[i] = " LIKE ";
                    sep[i] = " AND ";
                }
                List<Object> values = new ArrayList<>();
                for (Object val : For) {
                    values.add("%" + val + "%");
                    System.out.println(" Val is  " + val);
                }
                String getSQL = makeSQl(header, by, op, sep);
                System.out.println(" Your SQL  IS  " + getSQL);
                preparedStatement = connection.prepareStatement(getSQL);
                for (int set = 1; set <= values.size(); set++) {
                    preparedStatement.setObject(set, values.get(set - 1));
                }
                resultSet = preparedStatement.executeQuery();
            } else {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(header);
            }

            return resultSet;


        } catch (SQLException e) {
            System.out.println("You Have An Error IN Check  Method   in  JdbcConnection class \n\n" +
                               "the Error Code  is     " + e.getErrorCode() + "\n\n" + "the Message   is     " +
                               e.getMessage() + "\n\n" + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet search(String[] tableNames, String[] fieldes, String[] joinCondition, String[] by,
                            List<Object> For) {
        return search(tableNames, fieldes, joinCondition, by, For, null, null);
    }

    public ResultSet search(String[] tableNames, String[] fieldes, String[] joinCondition, String[] by,
                            List<Object> For, String[] op, String[] sep) {
        try {
            if (tableNames == null || tableNames.length == 0)
                return null;
            else {
                if (tableNames.length > 1 && (joinCondition == null || joinCondition.length == 0))
                    return null;
                else {
                    int j = 0;
                    if (fieldes == null || fieldes.length == 0 || fieldes.equals(""))
                        fieldes = new String[] { "*" };


                    String header = selectHeader(" SELECT ", fieldes, " , ") + " FROM " + tableNames[0];
                    for (int i = 1; i < tableNames.length; i++) {
                        header += " JOIN  " + tableNames[i] + " ON " + joinCondition[j] + " = " + joinCondition[++j];
                        j++;
                        System.out.println("J is " + j);
                    }
                    System.out.println("Header  is " + header);
                    if (by != null && by.length > 0) {
                        header += " WHERE ";
                        if (op == null || op.equals("") || op.length == 0) {
                            op = new String[by.length];
                            for (int i = 0; i < by.length; i++)
                                op[i] = " LIKE ";
                        }
                        List check = Arrays.asList(op);
                        boolean checkOP = check.contains(" BETWEEN ");
                        if (sep == null || sep.equals("") || sep.length == 0) {
                            sep = new String[by.length];
                            for (int i = 0; i < by.length; i++)
                                sep[i] = " AND ";
                        }
                        List<Object> values = new ArrayList<>();
                        if (checkOP) {
                            for (Object val : For) {
                                values.add(val);
                                System.out.println(" Val is  " + val);
                                System.out.println(" Values is  " + values);
                            }
                        } else {
                            for (Object val : For) {
                                values.add("%" + val + "%");
                                System.out.println(" Val is  " + val);
                                System.out.println(" Values is  " + values);
                            }
                        }
                        String getSQL = makeSQl(header, by, op, sep);
                        System.out.println(" Your SQL  IS  " + getSQL);
                        preparedStatement = connection.prepareStatement(getSQL);
                        for (int set = 1; set <= values.size(); set++) {
                            preparedStatement.setObject(set, values.get(set - 1));
                           
                        }
                        
                        resultSet = preparedStatement.executeQuery();
                        //                System.out.println("BOOK TITLE "+resultSet.getObject("BOOK TITLE"));
                    } else {
                        statement = connection.createStatement();
                        resultSet = statement.executeQuery(header);
                    }

                    return resultSet;
                } // end Sup else
            } // end Super else

        } catch (SQLException e) {
            System.out.println("You Have An Error IN search  Method   in  JdbcConnection class \n\n" +
                               "the Error Code  is     " + e.getErrorCode() + "\n\n" + "the Message   is     " +
                               e.getMessage() + "\n\n" + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet search(String[] tableNames, String[] fieldes, String[] joinCondition1, String[] joinCondition2,
                            String[] by, List<Object> For) {
        try {
            if (tableNames == null || tableNames.length == 0)
                return null;
            else {

                if (tableNames.length > 1 &&
                    (joinCondition1 == null || joinCondition1.length == 0 || joinCondition2 == null ||
                     joinCondition2.length == 0))
                    return null;
                else {
                    int j = 0;
                    if (fieldes == null || fieldes.length == 0 || fieldes.equals(""))
                        fieldes = new String[] { "*" };

                    String header = selectHeader(" SELECT ", fieldes, " , ") + " FROM " + tableNames[0];
                    for (int i = 1; i < tableNames.length; i++) {
                        header += " JOIN  " + tableNames[i] + " ON " + joinCondition1[j] + " = " + joinCondition2[j];
                        j++;
                        System.out.println("J is " + j);
                    }
                    System.out.println("Header  is " + header);
                    if (by != null && by.length > 0) {
                        header += " WHERE ";
                        String[] op = new String[by.length];
                        String[] sep = new String[by.length];
                        for (int i = 0; i < by.length; i++) {
                            op[i] = " LIKE ";
                            sep[i] = " AND ";
                        }
                        List<Object> values = new ArrayList<>();
                        for (Object val : For) {
                            values.add("%" + val + "%");
                            System.out.println(" Val is  " + val);
                        }
                        String getSQL = makeSQl(header, by, op, sep);
                        System.out.println(" Your SQL  IS  " + getSQL);
                        preparedStatement = connection.prepareStatement(getSQL);
                        for (int set = 1; set <= values.size(); set++) {
                            preparedStatement.setObject(set, values.get(set - 1));
                        }
                        resultSet = preparedStatement.executeQuery();
                    } else {
                        statement = connection.createStatement();
                        resultSet = statement.executeQuery(header);
                    }

                    return resultSet;
                } // end Sup Else
            } // end Super else

        } catch (SQLException e) {
            System.out.println("You Have An Error IN search  Method   in  JdbcConnection class \n\n" +
                               "the Error Code  is     " + e.getErrorCode() + "\n\n" + "the Message   is     " +
                               e.getMessage() + "\n\n" + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet check(String tableNmae, String[] fieldes, String[] fildesCondition, Object[] attribute,
                           String[] op, String[] sep) {
        try {
            String header = selectHeader("SELECT ", fieldes, ",") + " FROM " + tableNmae;
            if (fildesCondition != null && fildesCondition.length > 0) {
                header += " WHERE ";
                if (op == null || op.equals("") || op.length == 0)
                    op = new String[] { " = " };

                if (sep == null || sep.equals("") || sep.length == 0)
                    sep = new String[] { " AND " };

                String getSQL = makeSQl(header, fildesCondition, op, sep);
                preparedStatement = connection.prepareStatement(getSQL);
                for (int set = 1; set <= attribute.length; set++) {
                    preparedStatement.setObject(set, attribute[set - 1]);
                }
                resultSet = preparedStatement.executeQuery();
            } else {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(header);
            }

            return resultSet;


        } catch (SQLException e) {
            System.out.println("You Have An Error IN Check  Method   in  JdbcConnection class \n\n" +
                               "the Error Code  is     " + e.getErrorCode() + "\n\n" + "the Message   is     " +
                               e.getMessage() + "\n\n" + e.toString());
            e.printStackTrace();
            return null;
        }

    }

    public ResultSet check(String tableName, String[] fieldes, String[] fildesCondition, Object[] attribute) {
        try {
            String header = selectHeader("SELECT ", fieldes, ",") + " FROM " + tableName;
            if (fildesCondition.length > 0) {
                header += " WHERE ";
                String getSQL = makeSQl(header, fildesCondition, " = ", " AND ");
                System.out.println("SQL    " + getSQL);
                preparedStatement = connection.prepareStatement(getSQL);
                for (int set = 1; set <= attribute.length; set++) {
                    preparedStatement.setObject(set, attribute[set - 1]);
                }
                resultSet = preparedStatement.executeQuery();
            } else {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(header);
            }

            return resultSet;


        } catch (SQLException e) {
            System.out.println("You Have An Error IN Check  Method   in  JdbcConnection class \n\n" +
                               "the Error Code  is     " + e.getErrorCode() + "\n\n" + "the Message   is     " +
                               e.getMessage() + "\n\n" + e.toString());
            e.printStackTrace();
            return null;
        }

    }

    public boolean Delete(Connection connection, String Table_Name, String[] Fields, String[] FieldsCondition, String[] Attributes)

        {
        String Header = "DELETE  FROM  " + Table_Name + " WHERE ";
        String DeleteSQL = makeSQl(Header, FieldsCondition, " = ", " AND ");
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(DeleteSQL);
            for (int set = 1; set <= Attributes.length; set++) {
                preparedStatement.setString(set, Attributes[set - 1]);
            }
            executeQ = preparedStatement.executeUpdate();

            if (executeQ > 0) {
                preparedStatement.close();
                return true;
            } else

                return false;


        } catch (SQLException e) {
            System.out.println("You Have An Error IN Delete  Method    IN JdbcConnection Class \n\n" +
                               "the Error Code  is     " + e.getErrorCode() + "\n\n" + "the Message   is     " +
                               e.getMessage() + "\n\n" + e.toString());


            return false;
        }

    }

    public boolean update(String tableName, String[] fieldes, Object[] fieldesValues, String[] fieldesCondition,
                          Object[] fieldesCondionValues) {
        boolean state = false;
        try {
            String Header = " UPDATE  " + tableName + " SET ";
            String updateSql = makeSQl(Header, fieldes, " = ", " , ");
            updateSql += makeSQl(" Where ", fieldesCondition, " = ", " and ");
            int generatedColumns[] = { 1 };
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql, generatedColumns);
            int i;
            for (i = 1; i <= fieldesValues.length; i++)

                preparedStatement.setObject(i, fieldesValues[i - 1]);

            for (int z = i; z < fieldesCondionValues.length + i; z++)

                preparedStatement.setObject(z, fieldesCondionValues[z - i]);

            executeQ = preparedStatement.executeUpdate();
            if (executeQ > 0) {
                state = true;
                System.out.println("executeQ  " + executeQ);
            }
            //
            //                return resultSet;
            //            } else {
            //                System.out.println("executeQ  " + executeQ);
            //                return null;
            //            }

        } catch (SQLException e) {
            System.out.println("You Have An Error IN update  Method  in JdbcConnection Class  \n\n" +
                               "the Error Code  is     " + e.getErrorCode() + "\n\n" + "the Message   is     " +
                               e.getMessage() + "\n\n" + e.toString());
            e.printStackTrace();
            return false;
        }
        return state;
    }

    private String selectHeader(String header, String[] fieldes, String sep) {
        Sql = header;
        for (int i = 0; i < fieldes.length; i++) {
            Sql += "" + fieldes[i] + sep;
        }
        Sql = Sql.substring(0, Sql.length() - sep.length());
        return Sql;
    }

    private String makeSQl(String header, String[] Fieldes, String Op, String Sep) {
        Sql = header;
        for (int i = 0; i < Fieldes.length; i++) {
            Sql += "" + Fieldes[i] + Op + "?" + Sep;
        }
        Sql = Sql.substring(0, Sql.length() - Sep.length());
        return Sql;
    }

    private String makeSQl(String header, String[] Fieldes, String[] Op, String[] Sep) {
        Sql = header;
        int i;
        for (i = 0; i < Fieldes.length; i++) {
            Sql += "" + Fieldes[i] + Op[i] + "?" + Sep[i];
        }
        Sql = Sql.substring(0, Sql.length() - Sep[i - 1].length());
        return Sql;
    }

    private int getID(String Table_Name, String GetColume) {
        try {
            String string_String = "Select NVL( MAX( " + GetColume + " ) , 0)  " + " FROM " + Table_Name;
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(string_String);
            if (resultSet.next()) {
                getID = resultSet.getInt(1);
                //System.out.println(" The row insertted" + resultSet.getInt(1));
                return getID + 1;

            }

        } catch (SQLException e) {
            System.out.println("You Have An Error IN Get_Max_ID  Method   \n\n" + "the Error Code  is     " +
                               e.getErrorCode() + "\n\n" + "the Message   is     " + e.getMessage() + "\n\n" +
                               e.toString());
            return getID;
        }
        return getID;
    }


}


