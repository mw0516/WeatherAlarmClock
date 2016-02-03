/*
 * Copyright (c) 2016. Kaku咖枯 Inc. All rights reserved.
 */
package com.kaku.weac.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.kaku.weac.R;
import com.kaku.weac.util.MyUtil;
import com.kaku.weac.zxing.encoding.EncodingUtils;


/**
 * 造码Activity
 *
 * @author 咖枯
 * @version 1.0 2016/2/2
 */
public class GenerateCodeActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mActionOverflow;
    private PopupMenu mPopupMenu;
    private EditText mQrCodeEt;
    private CheckBox mLogoCb;
    private ImageView mQrCodeResultIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_code);
        ViewGroup background = (ViewGroup) findViewById(R.id.background);
        MyUtil.setBackground(background, this);
        assignViews();
    }

    private void assignViews() {
        ImageView actionBack = (ImageView) findViewById(R.id.action_back);
        final Button generateQRcodeBtn = (Button) findViewById(R.id.generate_qr_code_btn);
        mActionOverflow = (ImageView) findViewById(R.id.action_overflow);
        mQrCodeEt = (EditText) findViewById(R.id.qr_code_et);
        mLogoCb = (CheckBox) findViewById(R.id.logo_cb);
        mQrCodeResultIv = (ImageView) findViewById(R.id.qr_code_result_iv);

        actionBack.setOnClickListener(this);
        mActionOverflow.setOnClickListener(this);

        generateQRcodeBtn.setOnClickListener(this);
        generateQRcodeBtn.setClickable(false);

        mQrCodeEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @SuppressWarnings("deprecation")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    generateQRcodeBtn.setClickable(false);
                    generateQRcodeBtn.setBackgroundResource(R.drawable.shape_circle_btn_sure_invalidate);
                    generateQRcodeBtn.setTextColor(getResources().getColor(R.color.white_trans60));
                } else {
                    generateQRcodeBtn.setClickable(true);
                    generateQRcodeBtn.setBackgroundResource(R.drawable.bg_btn_sure);
                    generateQRcodeBtn.setTextColor(getResources().getColor(R.color.white_trans90));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 返回
            case R.id.action_back:
                finish();
                break;
            // 生成二维码
            case R.id.generate_qr_code_btn:
                String contentString = mQrCodeEt.getText().toString();
                if (!contentString.equals("")) {
                    //根据字符串生成二维码图片并显示在界面上，第2,3个参数为图片宽高
                    Bitmap qrCodeBitmap = EncodingUtils.createQRCode(contentString, 600, 600,
                            mLogoCb.isChecked() ?
                                    BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher) :
                                    null);
                    mQrCodeResultIv.setImageBitmap(qrCodeBitmap);
                }
                break;
            // 更多（溢出菜单按钮）
            case R.id.action_overflow:
                if (mPopupMenu == null) {
                    mPopupMenu = new PopupMenu(this, mActionOverflow);
                    mPopupMenu.getMenuInflater().inflate(R.menu.generate_qr_code_overflow, mPopupMenu.getMenu());
                    mPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.select_logo:
                                    break;
                                case R.id.save_qr_code:
                                    break;
                            }
                            return true;
                        }
                    });
                    mPopupMenu.show();
                } else {
                    mPopupMenu.show();
                }
                break;
        }
    }
}