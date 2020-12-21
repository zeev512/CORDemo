package il.co.migdal.ins.module;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import com.google.inject.AbstractModule;
import com.google.inject.Module;

import java.io.IOException;

public class MainModule extends AbstractModule {
	@Override
	protected void configure() {
		try {
			ClassPath classPath = ClassPath.from(MainModule.class.getClassLoader());
			
			ImmutableSet<ClassInfo> classInfoList = classPath.getTopLevelClassesRecursive(MainModule.class.getPackage().getName());
			for(ClassInfo classInfo : classInfoList ){
				if(validateClass(classInfo))
					install((Module)classInfo.load().newInstance());
			}			
		} catch (IOException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		
	}
	
	boolean validateClass(ClassInfo classInfo){
		if(classInfo.getName().equals(MainModule.class.getName()))
			return false;	// no need to load the current class
		else if(classInfo.load().getSuperclass().equals(AbstractModule.class))
			return true;	// load if it's a sub class of AbstractModule 
		else{
			for(Class<?> interfaces : classInfo.load().getInterfaces()){
				if(interfaces.equals(Module.class)) 
					return true; // load if it implements Module
			}
			return false;
		}
	}
}
