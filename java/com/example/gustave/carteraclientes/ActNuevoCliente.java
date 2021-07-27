package com.example.gustave.carteraclientes;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.gustave.carteraclientes.BaseDatos.DatosOpenHelper;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActNuevoCliente extends AppCompatActivity {
    private EditText edtNombre;
    private EditText edtDireccion;
    private EditText edtEmail;
    private EditText edtTelefono;

    private SQLiteDatabase conexion;
    private DatosOpenHelper datosOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_nuevo_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtDireccion = (EditText) findViewById(R.id.edtDireccion);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtTelefono = (EditText) findViewById(R.id.edtTelefono);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_nuevo_cliente,menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        switch (id) {
            case R.id.action_ok:
                if (bCamposCorrectos()) {
                    try {
                        /*
                        datosOpenHelper = new DatosOpenHelper(this);
                        conexion = datosOpenHelper.getWritableDatabase();
                        StringBuilder sql = new StringBuilder();
                        sql.append("INSERT INTO CLIENTE (NOMBRE, DIRECCION EMAIL, TELEFONO) VALUES ('");
                        sql.append(edtNombre.getText().toString().trim() + "' , '");
                        sql.append(edtDireccion.getText().toString().trim() + "' , '");
                        sql.append(edtEmail.getText().toString().trim() + "' , '");
                        sql.append(edtTelefono.getText().toString().trim() + "' , '");

                        conexion.execSQL(sql.toString());
                        conexion.close();

                        finish();
                        */
                        public static class FeedEntry implements BaseColumns {
                            public static final String TABLE_NAME = "entry";
                            public static final String COLUMN_NAME_TITLE = "title";
                            public static final String COLUMN_NAME_SUBTITLE = "subtitle";

                            private static final String SQL_CREATE_ENTRIES =
                                    "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                                            FeedEntry._ID + " INTEGER PRIMARY KEY," +
                                            FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
                                            FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

                            private static final String SQL_DELETE_ENTRIES =
                                    "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
                            public class FeedReaderDbHelper extends SQLiteOpenHelper {
                                // If you change the database schema, you must increment the database version.
                                public static final int DATABASE_VERSION = 1;
                                public static final String DATABASE_NAME = "FeedReader.db";

                                public FeedReaderDbHelper(Context context) {
                                    super(context, DATABASE_NAME, null, DATABASE_VERSION);
                                }
                                public void onCreate(SQLiteDatabase db) {
                                    db.execSQL(SQL_CREATE_ENTRIES);
                                }
                                public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                                    // This database is only a cache for online data, so its upgrade policy is
                                    // to simply to discard the data and start over
                                    db.execSQL(SQL_DELETE_ENTRIES);
                                    onCreate(db);
                                }
                                public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                                    onUpgrade(db, oldVersion, newVersion);
                                }

                                FeedReaderDbHelper dbHelper = new FeedReaderDbHelper(getContext());

                            }

                    } catch (Exception ex) {
                        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                        dlg.setTitle("Aviso");
                        dlg.setMessage(ex.getMessage());
                        dlg.setNeutralButton("OK", null);
                        dlg.show();
                    }
                }
                else{
                    AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                    dlg.setTitle("Aviso");
                    dlg.setMessage("Existen campos vacios");
                    dlg.setNeutralButton("OK", null);
                    dlg.show();
                }
                //Toast.makeText(this,"Boton Ok seleccionado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_cancelar:
                //Toast.makeText(this,"Boton Cancelar seleccionado",Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean bCamposCorrectos() {
        boolean res = true;
        if (edtNombre.getText().toString().trim().isEmpty()) {
            edtNombre.requestFocus();
            res = false;
        }
        if (edtDireccion.getText().toString().trim().isEmpty()) {
            edtNombre.requestFocus();
            res = false;
        }
        if (edtEmail.getText().toString().trim().isEmpty()) {
            edtNombre.requestFocus();
            res = false;
        }
        if (edtTelefono.getText().toString().trim().isEmpty()) {
            edtNombre.requestFocus();
            res = false;
        }
        return res;
    }

}
