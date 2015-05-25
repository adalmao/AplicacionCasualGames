package com.example.alvaro.aplicationgames;

/**
 * Created by ALVARO on 29/04/2015.
 */
import java.sql.ResultSet;
import java.sql.SQLException;

public class CLogin extends CBase {
    public String pcNombre;

    public boolean omLogin(String p_cCodUsu) {
        boolean llOk = true;
        String lcEstado, lcClave;
        CSql loSql = new CSql();
        llOk = loSql.omConnect();
        if (!llOk) {
            this.lcError = loSql.getError();
            return false;
        }
        //String lcSql = "SELECT cNombre, cEstado, cClave FROM L01MPER WHERE cCodPer = '" + p_cCodUsu + "' AND cClave = MD5('" + p_cClave + "')";
        String lcSql = "SELECT cNombre, cEstado, cClave FROM V_DOCENTES WHERE cCodDoc = '" + p_cCodUsu + "'";
        ResultSet RS = loSql.omExecRS(lcSql);
        if (RS == null) {
            loSql.omDisconnect();
            this.lcError = "<DATA><ERROR>NO EXISTE CODIGO DE DOCENTE [" + p_cCodUsu + "]</ERROR></DATA>";
            return false;
        }
        try {
            this.pcNombre = "<DATA><CNOMBRE>" + RS.getString(1).trim() + "</CNOMBRE></DATA>";
            lcEstado = RS.getString(2);
            lcClave  = RS.getString(3);
        } catch (SQLException E) {
            this.lcError = "<DATA><ERROR>ERROR AL LEER RS</ERROR></DATA>";
            loSql.omDisconnect();
            return false;
        }
        loSql.omDisconnect();
        /*if (!this.MD5(p_cClave).equals(lcClave)) {
            llOk = false;
            this.lcError = "<DATA><ERROR>ERROR: CLAVE ERRADA</ERROR></DATA>";
        } else if (!lcEstado.equals("A")) {
            llOk = false;
            this.lcError = "<DATA><ERROR>USUARIO NO ESTA ACTIVO</ERROR></DATA>";
        }*/
        return llOk;
    }
}
