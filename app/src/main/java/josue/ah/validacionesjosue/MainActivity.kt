package josue.ah.validacionesjosue

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        val txtnombre= findViewById<EditText>(R.id.txtNombre)
        val txtcorreo= findViewById<EditText>(R.id.txtCorreo)
        val txtcontrasena= findViewById<EditText>(R.id.txtContrasena)
        val txtedad= findViewById<EditText>(R.id.txtEdad)
        val txtdui= findViewById<EditText>(R.id.txtDUI)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        //2- Procesamos el boton

        btnAgregar.setOnClickListener {
            //Validamos que los campos no esten vacios
            if (txtnombre.text.isEmpty() || txtcorreo.text.isEmpty()
                || txtcontrasena.text.isEmpty() || txtedad.text.isEmpty()
                ||txtdui.text.isEmpty())
        }


    }
}