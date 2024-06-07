package josue.ah.validacionesjosue

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class activity_Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splashscreen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Cremos una corrutina
        //Tiene que ser en el hilo main para que si se muestre
        //Cosas en pantalllas

        GlobalScope.launch(Dispatchers.Main){
            //Esperar 3 segundos
            delay(3000)
            //Inicia la activity
            val pantallaInicio = Intent(this@activity_Splashscreen, MainActivity::class.java)
            startActivity(pantallaInicio)
            //Finalizar
            finish()
        }

    }
}