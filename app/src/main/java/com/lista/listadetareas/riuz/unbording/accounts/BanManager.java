    package com.lista.listadetareas.riuz.unbording.accounts;

        import android.app.AlertDialog;
        import android.content.Context;                    import com.lista.listadetareas.riuz.unbording.R;
        import android.content.DialogInterface;

    public class BanManager {

        public void manager (Context context) {
            userData data = new userData();
            if (data.getBaneo()){
                AlertDialog.Builder dialog = new AlertDialog.Builder(context , R.style.DialogBan);
                dialog.setTitle("Cuenta baneada");
                dialog.setMessage(data.getNombre() + " al parecer tu cuenta ha sido baneada de manera indefinida \n");
                dialog.setCancelable(false);
                dialog.setPositiveButton("Cerrar sesion", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        }
    }
