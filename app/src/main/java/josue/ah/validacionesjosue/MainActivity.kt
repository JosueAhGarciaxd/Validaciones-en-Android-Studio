package josue.ah.validacionesjosue

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1- Mandar a llamar a todos los elemento de la vista
        val txtNombre= findViewById<EditText>(R.id.txtNombre)
        val txtCorreo= findViewById<EditText>(R.id.txtCorreo)
        val txtContrasena= findViewById<EditText>(R.id.txtContrasena)
        val txtEdad= findViewById<EditText>(R.id.txtEdad)
        val txtDui= findViewById<EditText>(R.id.txtDUI)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        //2- Procesamos el boton

        btnAgregar.setOnClickListener {
            //Validamos que los campos no esten vacios
            if (txtNombre.text.isEmpty() || txtCorreo.text.isEmpty()
                || txtContrasena.text.isEmpty() || txtEdad.text.isEmpty()
                ||txtDui.text.isEmpty()){
                Toast.makeText(this, "Campos vacios", Toast.LENGTH_LONG).show()
            }else{

                //Comprobar que solo se ingresen numeros
                if(!txtEdad.text.matches("[0-9]+".toRegex())) {
                    Toast.makeText(this, "Ingrese solo numeros", Toast.LENGTH_LONG).show()
                }else{
                    //Validar Correo Electronico
                    if (!txtCorreo.text.matches("[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+".toRegex())){
                        Toast.makeText(this, "Ingrese correo valido", Toast.LENGTH_LONG).show()
                    }else{
                        //validar que la contraeña tenga un minimo de 6 caracteres
                        if (txtContrasena.text.length < 6 || txtContrasena.text.matches("[0-9]+".toRegex())){
                            Toast.makeText(this, "La clave debe contener mas de 6 digitos", Toast.LENGTH_LONG).show()
                        }



                    }
                }

            }
        }


    }
}