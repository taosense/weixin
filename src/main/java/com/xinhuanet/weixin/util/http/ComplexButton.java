package com.xinhuanet.weixin.util.http;

/**
 * 复杂按钮（父按钮） 
 * @author tao
 *
 */
public class ComplexButton extends Button {  
    private Button[] sub_button;  
  
    public Button[] getSub_button() {  
        return sub_button;  
    }  
  
    public void setSub_button(Button[] sub_button) {  
        this.sub_button = sub_button;  
    }  
}  
