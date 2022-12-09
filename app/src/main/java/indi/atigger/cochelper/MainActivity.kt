package indi.atigger.cochelper

import android.content.ComponentName
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button? = findViewById(R.id.button)
        val button1: Button? = findViewById(R.id.button2)
        val editText: EditText? = findViewById(R.id.editTextTextPersonName)
        val toast: Toast =
            Toast.makeText(applicationContext, "暂不支持此链接", Toast.LENGTH_SHORT)

        button?.setOnClickListener {
            var urlText: String = editText?.text.toString()
            if (urlText.indexOf("tencent") != -1) {
                var startNum : Int = urlText.indexOf("?")
                urlText = urlText.substring(startNum + 1)
                urlText = "clashofclans://" + urlText
                val componentName = ComponentName(
                    "com.tencent.tmgp.supercell.clashofclans",
                    "com.supercell.titan.tencent.GameAppTencent"
                )
                intent.component = componentName
                intent.setData(urlText.toUri())
                startActivity(intent)
            } else {
                toast.show()
            }
        }

        button1?.setOnClickListener{
            editText?.text = null;
        }
    }
}