package com.minseo.gogogo_ver2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.io.*
import java.lang.Exception

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, NAME, FACTORY, VERSION) {
    init {
        // TODO Auto-generated constructor stub
        try {
            val bResult = isCheckDB(context) // DB가 있는지?
            Log.i("DatabaseHelper", "DB Check=$bResult")
            if (!bResult) {   // DB가 없으면 복사
                copyDB(context)
            } else {
            }
        } catch (e: Exception) {
        }
    }

    // DB가 있나 체크함수
    fun isCheckDB(mContext: Context?): Boolean {
        val filePath = "/data/data/" + PACKEGE + "/databases/" + DB
        val file = File(filePath)
        return if (file.exists()) {
            true
        } else false
    }

    // DB를 복사하기
    // assets의 /db/xxxx.db 파일을 설치된 프로그램의 내부 DB공간으로 복사하기
    fun copyDB(mContext: Context) {
        Log.d("DatabaseHelper", "copyDB실행")

        val manager = mContext.assets
        val folderPath = "/data/data/" + PACKEGE + "/databases"
        val filePath = "/data/data/" + PACKEGE + "/databases/" + DB
        val folder = File(folderPath)
        val file = File(filePath)

        var fos: FileOutputStream? = null
        var bos: BufferedOutputStream? = null

        try {
            //InputStream is = manager.open("db/" + DB);
            val `is` = manager.open(DB) //나는 애샛폴더에 바로 DB가 있으니까!
            val bis = BufferedInputStream(`is`)
            if (folder.exists()) {
            } else {
                folder.mkdirs()
            }
            if (file.exists()) {
                file.delete()
                file.createNewFile()
            }

            fos = FileOutputStream(file)
            bos = BufferedOutputStream(fos)
            var read = -1
            val buffer = ByteArray(1024)

            while (bis.read(buffer, 0, 1024).also { read = it } != -1) {
                bos.write(buffer, 0, read)
            }

            bos.flush()
            bos.close()
            fos.close()
            bis.close()
            `is`.close()
        } catch (e: IOException) {
            Log.e("ErrorMessage : ", e.message!!)
        }
    }

    /** Called when the activity is first created.  */
    override fun onCreate(db: SQLiteDatabase) {
        // String QUERY = "CREATE TABLE word (_id INTEGER PRIMARY KEY autoincrement, word_e TEXT , word_k TEXT)";
        // db.execSQL(QUERY);
        Log.e("ehsk", "eee")
        //String QUERY1 = "INSERT INTO word (word_e, word_k ) VALUES(apple , 사과)";
        //db.execSQL(QUERY1);
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // TODO Auto-generated method stub
        val QUERY = "DROP TABLE IF EXISTS word"
        db.execSQL(QUERY)
        onCreate(db)
    }

    companion object {
        var NAME = "store_data15.db" // to-do*
        var FACTORY: SQLiteDatabase.CursorFactory? = null
        var PACKEGE = "com.minseo.gogogo_ver2" //to-do
        var DB = "store_data15.db" // to-do*
        var VERSION = 1
    }
}