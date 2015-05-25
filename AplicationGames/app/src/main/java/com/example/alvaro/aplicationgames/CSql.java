package com.example.alvaro.aplicationgames;

/**
 * Created by ALVARO on 29/04/2015.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CSql extends CBase {
    protected Connection h;
    protected String lcTipo;

    public CSql() {
        this.lcTipo = "P";
    }

    public CSql(String p_cJdbc) {
        //this.jdbc = p_cJdbc;
        //this.mxLoadJdbc();
        //this.url=this.protocolo+"://"+this.ip+"/"+this.jdbc;
        //this.url = "jdbc:postgresql://localhost:5444/XYZ";
    }

    public CSql(String p_cJdbc, String p_cIp) {
        //this.jdbc = p_cJdbc;
        //this.ip = p_cIp;
    }

    public boolean omConnect() {
        boolean llOk = false;
        try {
            if (this.lcTipo.equals("P")) {
                Class.forName("org.postgresql.Driver");}
           } catch (ClassNotFoundException loErr) {
            this.lcError = "NO SE ENCONTRO EL DRIVER DEL POSTGRES";
        }
        try {
           this.h = DriverManager.getConnection("jdbc:postgresql://192.168.1.30:5432/Bd_CasualGames");
            llOk = true;
        } catch (SQLException E) {
            this.lcError = E.getMessage();
            E.printStackTrace();
        }
        if (llOk) {
            llOk = this.omExec("BEGIN;");
        }
        return llOk;
    }

    public ResultSet omExecRS(String p_cSql) {
        ResultSet RS = null;
        int i = 0;
        try {
            Statement s = this.h.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            RS = s.executeQuery(p_cSql);
            while (RS.next()) {
                i = 1;
                break;
            }
            if (i == 0) {
                RS = null;
            }
        } catch (SQLException E) {
            this.lcError = E.getMessage();
            E.printStackTrace();
        }
        return RS;
    }

    public boolean omExec(String p_cSql) {
        boolean llOk = false;
        try {
            PreparedStatement s = this.h.prepareStatement(p_cSql);
            llOk = s.execute();
            llOk = true;
        } catch (SQLException E) {
            E.printStackTrace();
            this.lcError = E.getMessage();
        }
        return llOk;
    }

    public void omDisconnect() {
        try {
            this.omExec("COMMIT;");
            this.h.close();
            this.h = null;
        } catch (SQLException E) {
            this.lcError = E.getMessage();
        }
    }

    public void rollback() {
        try {
            this.omExec("ROLLBACK;");
            this.h.close();
            this.h = null;
        } catch (SQLException E) {
            this.lcError = E.getMessage();
        }
    }
   /*
    protected void mxLoadJdbc() {
        String lcServer;
        File lcArchivo = null;
        FileReader loFr = null;
        BufferedReader loBr = null;
        try {
            lcArchivo = new File("/sif/sif.ini");
            loFr = new FileReader(lcArchivo);
            loBr = new BufferedReader(loFr);
            String lcLinea;
            while ((lcLinea = loBr.readLine()) != null) {
                if (lcLinea.equals("*" + this.jdbc)) {
                    this.tipo = this.jdbc.substring(this.jdbc.length() - 1);
                    lcLinea = loBr.readLine();
                    String lcDataBase = lcLinea.substring(1);
                    lcLinea = loBr.readLine();
                    lcServer = lcLinea.substring(1);
                    lcLinea = loBr.readLine();
                    String lcPort = lcLinea.substring(1);
                    lcLinea = loBr.readLine();
                    this.user = lcLinea.substring(1);
                    lcLinea = loBr.readLine();
                    this.password = lcLinea.substring(1);
                    if (this.tipo.equals("P")) {
                        this.url = this.protocolo + "://" + lcServer + ":" + lcPort + "/" + lcDataBase;
                    } else {
                        this.url = "jdbc:oracle:thin:@" + lcServer + ":" + lcPort + ":" + lcDataBase;
                    }
                }
            }
        } catch (Exception loErr) {
            loErr.printStackTrace();
        } finally {
            try {
                if (null != loFr) {
                    loFr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
   */
}