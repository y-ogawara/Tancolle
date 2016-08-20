package org.t_robop.y_ogawara.tancolle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class SettingActivity extends AppCompatActivity {

    //全体通知設定用チェックボックスの宣言
    CheckBox allNotif;
    //全体通知設定のフラグ(初期はonで)
    Boolean allNotifType=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        //全体通知設定用チェックボックスの関連付け
        allNotif=(CheckBox)findViewById(R.id.allnotif);
        //チェックボックスのリスナー設定
        checkBoxSet();
        //preferenceの「Setting」をプライベートモードで開く
        SharedPreferences pref = getSharedPreferences("Setting", MODE_PRIVATE);
        //開いたpreferenceの中の「allNotifType」の値を取得（保存されてない時はtrueを取得）
        allNotifType = pref.getBoolean("allNotifType", true);
        //取得したBoolean型に応じてチェックを変更
        allNotif.setChecked(allNotifType);
    }
    //表示設定クリック時
    public void drawsetting(View v){
        //表示設定用Activityに飛ぶ
            Intent intent = new Intent(SettingActivity.this, SettingDrawActivity.class);
            startActivity(intent);
        /////
    }
    //カテゴリ設定クリック時
    public void categorysetting(View v){
        //カテゴリ設定用Activityに飛ぶ
            Intent intent = new Intent(SettingActivity.this, SettingCategoryActivity.class);
            startActivity(intent);
        /////
    }
    //ライセンスクリック時
    public void license(View v){

    }
    //端末のバックボタンクリック時
    @Override
    public void onBackPressed() {
        //allNotifType(通知設定)の保存
            //preferenceの宣言
            SharedPreferences preferAllNotif;
            //preferenceの中の「Setting」をプライベートモードで開く
            preferAllNotif = getSharedPreferences("Setting", MODE_PRIVATE);
            //preferenceEditorの宣言
            SharedPreferences.Editor editor = preferAllNotif.edit();
            //開いたpreferenceの中の「allNotifType」の値を変更する
            editor.putBoolean("allNotifType", allNotifType);
            //editor終了
            editor.commit();
        /////
        //Activity終了
        finish();
    }
    //チェックボックスのリスナー登録
    public void checkBoxSet(){
        //チェックボックスがクリックされた時に呼び出されるコールバックリスナーを登録します
            allNotif.setOnClickListener(new View.OnClickListener() {
                @Override
                // チェックボックスがクリックされた時
                    public void onClick(View v) {
                        // チェックボックスのチェック状態を取得します
                        allNotifType=allNotif.isChecked();
                    }
                /////
            });
        /////
    }
}
