/**
 * TextMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.cosgui.datamodel;

public class TextMessage  implements java.io.Serializable {
    private java.lang.String message;

    private java.lang.String usernameSrc;

    private java.lang.String usernameDst;

    public TextMessage() {
    }

    public TextMessage(
           java.lang.String message,
           java.lang.String usernameSrc,
           java.lang.String usernameDst) {
           this.message = message;
           this.usernameSrc = usernameSrc;
           this.usernameDst = usernameDst;
    }


    /**
     * Gets the message value for this TextMessage.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this TextMessage.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the usernameSrc value for this TextMessage.
     * 
     * @return usernameSrc
     */
    public java.lang.String getUsernameSrc() {
        return usernameSrc;
    }


    /**
     * Sets the usernameSrc value for this TextMessage.
     * 
     * @param usernameSrc
     */
    public void setUsernameSrc(java.lang.String usernameSrc) {
        this.usernameSrc = usernameSrc;
    }


    /**
     * Gets the usernameDst value for this TextMessage.
     * 
     * @return usernameDst
     */
    public java.lang.String getUsernameDst() {
        return usernameDst;
    }


    /**
     * Sets the usernameDst value for this TextMessage.
     * 
     * @param usernameDst
     */
    public void setUsernameDst(java.lang.String usernameDst) {
        this.usernameDst = usernameDst;
    }

    public String toString() {
    	return new String (this.getUsernameSrc() + "|" + this.getUsernameDst() + "|" + this.getMessage());
    }
    
    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TextMessage)) return false;
        TextMessage other = (TextMessage) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.usernameSrc==null && other.getUsernameSrc()==null) || 
             (this.usernameSrc!=null &&
              this.usernameSrc.equals(other.getUsernameSrc()))) &&
            ((this.usernameDst==null && other.getUsernameDst()==null) || 
             (this.usernameDst!=null &&
              this.usernameDst.equals(other.getUsernameDst())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getUsernameSrc() != null) {
            _hashCode += getUsernameSrc().hashCode();
        }
        if (getUsernameDst() != null) {
            _hashCode += getUsernameDst().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TextMessage.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://wschat", "TextMessage"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wschat", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usernameSrc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wschat", "usernameSrc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usernameDst");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wschat", "usernameDst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
