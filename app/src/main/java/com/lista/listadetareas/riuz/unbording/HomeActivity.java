    package com.lista.listadetareas.riuz.unbording;

        import android.content.DialogInterface;
        import android.content.SharedPreferences;

        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;                                                       import android.widget.TextView;
        import android.widget.Toast;
        import com.android.volley.Request;
        import com.android.volley.RequestQueue;                                         import com.android.volley.toolbox.JsonObjectRequest;
        import com.android.volley.toolbox.Volley;                                       import com.lista.listadetareas.riuz.unbording.accounts.BanManager;
        import com.lista.listadetareas.riuz.unbording.accounts.userData;                import com.android.volley.VolleyError;
        import com.android.volley.Response;
        import org.json.JSONException;                                                 import org.json.JSONObject;


    public class HomeActivity extends AppCompatActivity {

        private RequestQueue queue;
        private static userData userData= new userData();
        private static String username;

        @Override protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

            if (MainActivity.key_session != null) {
                queue = Volley.newRequestQueue(this);
                autoLogin();
            } else {
                BanManager manager = new BanManager();
                manager.manager(this);

                TextView textView = findViewById(R.id.textName);
                textView.setText("Your name " + userData.getNombre());
            }
        }

        public void autoLogin () {

            String url = "http://192.168.1.11:5000/account/token/login/"+MainActivity.key_session;
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override public void onResponse(JSONObject response) {
                    try {
                        username = response.getString("nombre");
                        Toast.makeText(getApplicationContext(), username , Toast.LENGTH_LONG).show();
                        userData.setNombre(username);
                        TextView textView = findViewById(R.id.textName);
                        textView.setText("Your name " + userData.getNombre());
                    } catch (Exception e) {
                        try {
                            String error = response.getString("error");
                            switch (error){
                                case "erro.token.caduque":
                                    AlertDialog.Builder dialogError = new AlertDialog.Builder(HomeActivity.this , R.style.DialogBan);
                                                        dialogError.setTitle("Ha ocurrido un error");
                                                        dialogError.setMessage("Se ha cerrado la sesion forsosamente poque se a iniciado sesion en otro dispositivo.");
                                                        dialogError.setCancelable(false);
                                                        dialogError.setPositiveButton("Cerrar sesion", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                finish();
                                                            }
                                                        });
                                                        dialogError.show();
                                    break;
                            }
                        } catch (JSONException ex) {
                            ex.printStackTrace();
                            Toast.makeText(getApplicationContext() , "error ..." , Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }, new Response.ErrorListener() {
                @Override public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext() , "ERROR RESPONSE -> " +error.toString() , Toast.LENGTH_LONG).show();
                }
            });
            queue.add(jsonObjectRequest);
        }
    }
