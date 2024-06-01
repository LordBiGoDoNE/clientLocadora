package org.example.bean;

import java.beans.*;

public class CustomizedJTableBeanInfo extends SimpleBeanInfo {
    
    private final static Class beanClass = CustomizedJTable.class;
    private static BeanDescriptor beanDescriptor = null;
    
    @Override
    public BeanDescriptor getBeanDescriptor() {
        beanDescriptor = new BeanDescriptor(beanClass);
        beanDescriptor.setDisplayName("Customized Table");
        
        return beanDescriptor;
    }
}