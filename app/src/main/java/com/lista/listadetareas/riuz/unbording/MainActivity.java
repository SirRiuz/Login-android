    package com.lista.listadetareas.riuz.unbording;

        import android.app.Activity;                            import android.app.ProgressDialog;
        import android.content.Intent;                          import com.lista.listadetareas.riuz.unbording.accounts.userData;
        import android.os.Bundle;                               import java.io.InputStreamReader;
        import android.view.View;                               import android.widget.Button;
        import android.widget.EditText;                         import android.text.TextUtils;
        import android.widget.TextView;                         import com.android.volley.toolbox.Volley;
        import android.widget.Toast;
        import org.json.JSONObject;
        import com.android.volley.Request;                      import com.android.volley.RequestQueue;
        import com.android.volley.Response;                     import androidx.appcompat.app.AppCompatActivity;
        import java.io.BufferedReader;
        import java.io.OutputStream;
        import java.io.OutputStreamWriter;
        import com.android.volley.VolleyError;                  import com.android.volley.toolbox.JsonObjectRequest;

    public class MainActivity extends AppCompatActivity {

            private EditText correo,contraseña;
            private Button btn_iniciar;
            private RequestQueue queue ;
            private ProgressDialog dialog;
            private TextView MsgCoreo , MsgContraseña;

            public static final userData data = new userData();
            public static String key_session = null;

        @Override protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                queue = Volley.newRequestQueue(this);
                autoLogin();

                MsgCoreo = findViewById(R.id.mensajeCorreo);
                MsgCoreo.setVisibility(View.INVISIBLE);

                MsgContraseña = findViewById(R.id.mensajeContraseña);
                MsgContraseña.setVisibility(View.INVISIBLE);

                correo =  (EditText) findViewById(R.id.et_correo);
                contraseña = (EditText) findViewById(R.id.et_contraseña);
                btn_iniciar = (Button) findViewById(R.id.btn_iniciar);
                dialog = new ProgressDialog(this , R.style.DialogLoader);
                dialog.setMessage("Conectando");
                dialog.setCancelable(false);

            btn_iniciar.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {

                        if (ComproCampos()) {
                            login(correo.getText().toString() , contraseña.getText().toString());
                            dialog.show();
                        }

                    }
                });
            }

            public void login (String correo , String contraceña) {

                String url = "http://192.168.1.11:5000/"+correo+"/"+contraceña;
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override public void onResponse(JSONObject response) {
                        try{
                            String responseError = response.getString("error");
                            switch (responseError) {
                                case "password.no.exits":
                                    setPasswordError("Contraseña incorrecta");
                                    Toast.makeText(getApplicationContext() , "password.no.exits" , Toast.LENGTH_LONG).show();
                                    break;

                                case "correo.no.exits":
                                    setEmailError("El coreo no existe");
                                    Toast.makeText(getApplicationContext() , "correo.no.exits" , Toast.LENGTH_LONG).show();
                                    break;
                            }
                        } catch (Exception e) { getDataUser(response); }

                        dialog.cancel();
                    }
                }, new Response.ErrorListener() {
                    @Override public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext() ,"Error: " + error.toString() , Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });
                queue.add(request);
            }

            public void getDataUser (JSONObject response) {
                try {
                    String nombre = response.getString("nombre");
                    String key_session = response.getString("session_key");
                    String id = response.getString("id");
                    boolean ban_user = response.getBoolean("ban");
                    String session_token = response.getString("session_key");

                    data.setToken(session_token);
                    data.setId(id);
                    Toast.makeText(getApplicationContext() , key_session , Toast.LENGTH_LONG).show();
                    data.setNombre(nombre);
                    Toast.makeText(getApplicationContext() , "Estado del baneo " + data.getBaneo() , Toast.LENGTH_LONG).show();
                    data.setBaneo(ban_user);
                    Toast.makeText(getApplicationContext() , data.getNombre() , Toast.LENGTH_LONG).show();
                    createDateSession(data.getToken());
                    startActivity(new Intent(MainActivity.this , HomeActivity.class));
                    finish();
                } catch (Exception e) { }

            }

            public void createDateSession (String IdSession) {
                try {
                    OutputStreamWriter createFile = new OutputStreamWriter(openFileOutput("session.txt" , Activity.MODE_PRIVATE));
                    createFile.write(IdSession);
                    createFile.close();
                    Toast.makeText(getApplicationContext() , "Sis e creao el archivo -> " + IdSession , Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext() , "No se creo el archivo -> " + IdSession , Toast.LENGTH_LONG).show();
                }
            }

            public boolean keyExits (String FileName) {

                boolean fileExits = false;
                String files[] = fileList();
                for (String filename : files) {

                    if (FileName.equals(filename)) {
                        fileExits = true;
                        break;
                    }
                }
                return fileExits;
            }

            public void setEmailError (String mensaje) {
                int drawable = R.drawable.color_error;
                correo.setBackgroundResource(drawable);
                MsgCoreo.setText(mensaje);
                MsgCoreo.setVisibility(View.VISIBLE);
            }

        public void setPasswordError (String mensaje) {
            int drawable = R.drawable.color_error;
            contraseña.setBackgroundResource(drawable);
            MsgContraseña.setText(mensaje);
            MsgContraseña.setVisibility(View.VISIBLE);
        }


        public void ResetErrorPassword () {
            int drawable = R.drawable.shape;
            contraseña.setBackgroundResource(drawable);
            MsgContraseña.setText("");
            MsgContraseña.setVisibility(View.INVISIBLE);
        }

        public void ResetErrorEmail () {
            int drawable = R.drawable.shape;
            correo.setBackgroundResource(drawable);
            MsgCoreo.setText("");
            MsgCoreo.setVisibility(View.INVISIBLE);
        }

        public boolean ComproCampos () {

            boolean comCampos = false;

            if (correo.getText().toString().equals("")){
                setEmailError("El campo esta vacio");
                comCampos = false;
                Toast.makeText(this , "El correo es : " + comCampos , Toast.LENGTH_LONG).show();
            } else {

                ResetErrorEmail();
                ResetErrorPassword();

                if (contraseña.getText().toString().equals("")){
                    setPasswordError("El campo esta vacio");
                    comCampos = false;
                } else  {
                    comCampos = true;
                }
            }
            Toast.makeText(this , "Comprobando campos retorna " + comCampos , Toast.LENGTH_LONG).show();
            return comCampos;
        }

        public void autoLogin () {
            if(keyExits("session.txt")) {

                try{
                    InputStreamReader reader = new InputStreamReader(openFileInput("session.txt"));
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    key_session = bufferedReader.readLine().toString();
                    Toast.makeText(this , "Llave guardada "+MainActivity.key_session , Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    finish();
                } catch (Exception e) {
                    Toast.makeText(this , "No se a podido leer el archivo de session" , Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(this , "No hay llaves guardadas ..." , Toast.LENGTH_LONG).show();
            }
        }
    }
