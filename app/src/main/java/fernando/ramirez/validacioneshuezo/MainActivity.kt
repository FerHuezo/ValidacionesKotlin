package fernando.ramirez.validacioneshuezo

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
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtCorreo = findViewById<EditText>(R.id.txtEmail)
        val txtPassword = findViewById<EditText>(R.id.txtPassword)
        val txtEdad = findViewById<EditText>(R.id.txtEmail)
        val txtDUI = findViewById<EditText>(R.id.txtDUI)
        val btnProbar = findViewById<Button>(R.id.btnProbar)

        btnProbar.setOnClickListener {
            if(txtNombre.text.isEmpty() || txtCorreo.text.isEmpty()
                || txtPassword.text.isEmpty() || txtEdad.text.isEmpty()
                || txtDUI.text.isEmpty())
            {
                Toast.makeText(this, "Campos vacios", Toast.LENGTH_LONG).show()
            }
            else
            {
                if(!txtEdad.text.matches("[0-9]+".toRegex()))
                {
                    Toast.makeText(this, "Datos guardados", Toast.LENGTH_LONG).show()
                }
                else
                {
                    if (!txtCorreo.text.matches("[a-zA-Z0-9.-_]+@[a-zA-Z]+\\.+[a-z]+".toRegex()))
                    {
                        Toast.makeText(this, "Ingrese correo valido", Toast.LENGTH_LONG).show()
                    }
                    else
                    {
                        if (txtPassword.text.length < 6 || txtPassword.text.matches("[0-9]+".toRegex()))
                        {
                            Toast.makeText(this, "La contraseña debe contenes más de 6 digitos", Toast.LENGTH_LONG).show()
                        }
                        else
                        {
                            if (txtDUI.text.length < 10 || txtDUI.text.matches("[0-9]+-[0-9]".toRegex()))
                            {
                                Toast.makeText(this, "DUI incompleto", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }
            }
        }
    }
}
