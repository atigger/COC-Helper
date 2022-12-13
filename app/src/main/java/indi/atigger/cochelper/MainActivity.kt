package indi.atigger.cochelper

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri


/**
 * MainActivity.kt
 *
 * @author atigger
 *
 * create on 2022/12/9
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button? = findViewById(R.id.button)
        val button1: Button? = findViewById(R.id.button2)
        val editText: EditText? = findViewById(R.id.editTextTextPersonName)
        val textView2: TextView? = findViewById(R.id.textView2)
        val textView: TextView? = findViewById(R.id.textView)
        val toast: Toast =
            Toast.makeText(applicationContext, "暂不支持此链接\n国服和国际服数据不互通", Toast.LENGTH_SHORT)

        /**
         * 使用阵型点击事件，替换链接关键字之后通过intent打开应用
         */
        button?.setOnClickListener {
            var urlText: String = editText?.text.toString()
            if (urlText.indexOf("=tencent") != -1 || urlText.indexOf("=IOS") != -1) {
                var startNum: Int = urlText.indexOf("?")
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

        /**
         * 重置按钮
         */
        button1?.setOnClickListener {
            editText?.text = null;
        }

        /**
         * 开源地址
         */
        textView?.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://github.com/atigger/COC-Helper")
            }
            startActivity(intent)
        }

        /**
         * 教程按钮
         */
        textView2?.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://b23.tv/CfibBOh")
            }
            startActivity(intent)
        }
    }
}