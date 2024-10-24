package com.likobehruz.dialogs

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.likobehruz.dialogs.databinding.ActivityMainBinding
import com.likobehruz.dialogs.databinding.ItemDialogBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Attention")
            dialog.setCancelable(false)
            dialog.setMessage("Are you sure want to delete it ?")
            dialog.setPositiveButton("Yes",object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "Deleted", Toast.LENGTH_SHORT).show()

                }
            })
            dialog.setNegativeButton("Cancel", object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "Canceled", Toast.LENGTH_SHORT).show()
                }
            })
            dialog.show()
        }

        binding.btn2.setOnClickListener {

            val dialog = AlertDialog.Builder(this)
            val itemDialog= ItemDialogBinding.inflate(layoutInflater)

            itemDialog.btnLike.setOnClickListener {
                itemDialog.tv.text="Liked"
            }
            itemDialog.btnDislike.setOnClickListener {
                itemDialog.imageIphone.visibility= View.INVISIBLE

            }

            binding.btn3.setOnClickListener {

                val dialog= BlankFragment()
                dialog.show(supportFragmentManager, "Mr Bexruz")

            }

            binding.btn6.setOnClickListener {
                val dialog = BottomSheetDialog(this)
                val itemDialog= ItemDialogBinding.inflate(layoutInflater)
                dialog.setContentView(itemDialog.root)
                dialog.show()
            }

            binding.btn4.setOnClickListener {
                val datePickerDialog = DatePickerDialog(this)

                datePickerDialog.setOnDateSetListener { view, year, month, dayOfMonth ->
                    Toast.makeText(this, "${dayOfMonth}.${month+1}.$year", Toast.LENGTH_SHORT).show()
                }

                datePickerDialog.show()
            }

            binding.btn5.setOnClickListener {
                val timePickerDialog = TimePickerDialog(
                    this,
                    object : TimePickerDialog.OnTimeSetListener {
                        override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                            Toast.makeText(this@MainActivity, "$hourOfDay:$minute", Toast.LENGTH_SHORT).show()
                        }

                    },
                    24,
                    60,
                    true
                )
//            timePickerDialog.updateTime(LocalTime.now().hour, LocalTime.now().minute)
                timePickerDialog.updateTime(12, 50)
                timePickerDialog.show()
            }

            binding.btn7.setOnClickListener {
                val snackbar = Snackbar.make(it, "Hammasi ishladi ", Snackbar.LENGTH_LONG)

                snackbar.setAction("Ball Qoyish", object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        Toast.makeText(this@MainActivity, "Ball Qoyildi ", Toast.LENGTH_SHORT).show()
                    }
                })

                snackbar.show()
            }



            dialog.setView(itemDialog.root)
            dialog.show()


        }

        
    }
}