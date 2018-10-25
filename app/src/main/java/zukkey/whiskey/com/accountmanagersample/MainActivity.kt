package zukkey.whiskey.com.accountmanagersample

import android.accounts.AccountManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView


class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val emailPattern = Patterns.EMAIL_ADDRESS
    val accounts = AccountManager.get(this).accounts
    val emailList = mutableListOf<String>()
    for (account in accounts) {
      if (emailPattern.matcher(account.name).matches()) {
        emailList.add(account.name)
      }
    }
    val emails = ArrayAdapter<String>(this, R.layout.item_email_list, emailList)
    val editText = findViewById<AutoCompleteTextView>(R.id.edit_text)
    editText.setAdapter(emails)
    editText.threshold = 1
  }
}
