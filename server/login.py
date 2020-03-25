


from flask import Flask , jsonify
from flask_mysqldb import MySQL
from generateKey import generateToken as token_session

app = Flask(__name__)

app.config['MYSQL_USER'] = 'root'
app.config['MYSQL_PASSWORD'] = '';
app.config['MYSQL_HOST'] = 'localhost';
app.config['MYSQL_DB'] = 'data-machin'

mysql = MySQL(app)


@app.route("/account/token/login/<token_session>")
def autoLogin (token_session):


    try:
        consulta_token = mysql.connect.cursor()
        consulta_token.execute('''SELECT * FROM usuarios WHERE session_token = '{}' '''.format(token_session))
        getusers = consulta_token.fetchall()

        print(getusers)

        return jsonify({

            'id' : getusers[0][3],
            'token' : getusers[0][5],
            'nombre' : getusers[0][1],
            'apellido' : getusers[0][4],
            'session_key' : getusers[0][6],
            'correo' :getusers[0][0],
            })

    except Exception:
        return jsonify( {'error' : 'erro.token.caduque'} )

@app.route("/<user>/<passw>")
def index (user , passw):

    try:
        cr = mysql.connect.cursor()
        cr.execute('''SELECT * FROM usuarios WHERE Correo = '{}' '''.format(user))
        correo = cr.fetchall()
        print(correo[0][0])
        return autentication(user , passw)

    except IndexError as e:
        return jsonify( { 'error' : 'correo.no.exits' } )






#Este metodo realiza a autenticacion si el correo
#electronico existe


def autentication (correo ,contraseña):

    autenticacion = mysql.connect.cursor()
    autenticacion.execute('''SELECT * FROM usuarios WHERE Correo = '{}' AND Contraseña = '{}' '''.format(correo , contraseña))
    autentication_key = autenticacion.fetchall()
    mysql.connect.commit()


    mysql.connect.commit()

    if len(autentication_key) == 0 :
        return jsonify( { 'error' : 'password.no.exits' } )


    return jsonify({

         'id' : autentication_key[0][3],
         'token' : autentication_key[0][5],
         'nombre' : autentication_key[0][1],
         'apellido' : autentication_key[0][4],
         'session_key' : autentication_key[0][6],
         'correo' :autentication_key[0][0],
         'ban':autentication_key[0][7]
         })


if __name__ == "__main__":
    app.run( debug=True, host='0.0.0.0', port=5000 )