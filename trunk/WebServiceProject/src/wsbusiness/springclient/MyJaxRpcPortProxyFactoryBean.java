package wsbusiness.springclient;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.encoding.TypeMapping;
import javax.xml.rpc.encoding.TypeMappingRegistry;

import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.springframework.remoting.jaxrpc.JaxRpcPortProxyFactoryBean;

public class MyJaxRpcPortProxyFactoryBean extends JaxRpcPortProxyFactoryBean {

	protected void postProcessJaxRpcService(Service service) {
		TypeMappingRegistry registry = service.getTypeMappingRegistry();
		TypeMapping mapping = registry.getDefaultTypeMapping();
		//registerBeanMapping(mapping, MyPhoto.class, "Photo");
		String[] array = registry.getRegisteredEncodingStyleURIs();
		for (int i = 0; i < array.length; i++) {
			System.out.println("Encoding style: " + array[0]);
			registry.register(array[0], mapping);
		}
	}
	
	protected void registerBeanMapping(TypeMapping mapping, Class type, String name) {
	      QName qName = new QName("http://wsbusiness", name);
	      mapping.register(type, qName, new BeanSerializerFactory(type, qName),
							  new BeanDeserializerFactory(type, qName));
	}

}
