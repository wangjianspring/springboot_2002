/**    
 * 文件名：ToEntityUtil.java      
 * 版本信息：    
 * 日期：2014-8-15    
 * Copyright     
 *    
 */
package hxzy.com.cn.springdata.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ToEntityUtil {
	@SuppressWarnings("unchecked")
	public static <T> T toEntityList(List<?> datas, Class<?> clas, String... labels) {
		// 返回实体列表
		List<T> entitys = new ArrayList<T>();
		for (int i = 0; i < datas.size(); i++) {
			// 结果集对象
			Object[] data = (Object[]) datas.get(i);
			T entity;
			try {
				entity = toEntity(clas, data, labels);
				entitys.add(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return (T) entitys;
	}

	@SuppressWarnings("unchecked")
	public static <T> T toEntity(Class<?> clas, Object[] data, String... labels) throws Exception {
		// 创建对象实例
		T entity = (T) clas.newInstance();
		// 每个字段进行赋值
		for (int j = 0; j < labels.length; j++) {
			if (null == data[j] || 0 == data[j].toString().trim().length()) {
				continue;
			}
			// 得到设值方法名称
			String methodName = "set" + ((labels[j].charAt(0) + "").toUpperCase()) + labels[j].substring(1);
			// 得到字段名称
			Field field = entity.getClass().getDeclaredField(labels[j]);
			// 得到字段类型
			String parameterType = field.getType().getSimpleName();
			// 得到设值方法
			Method method = entity.getClass().getDeclaredMethod(methodName, field.getType());
			String val = data[j].toString();
			if (parameterType.equals("String")) {
				method.invoke(entity, val);
			} else if (parameterType.equals("Character")) {
				method.invoke(entity, val.charAt(0));
			} else if (parameterType.equals("Boolean")) {
				method.invoke(entity, val.equals("true") || val.equals("1") ? true : false);
			} else if (parameterType.equals("Short")) {
				method.invoke(entity, Short.parseShort(val));
			} else if (parameterType.equals("Integer")) {
				method.invoke(entity, Integer.parseInt(val));
			} else if (parameterType.equals("Float")) {
				method.invoke(entity, Float.parseFloat(val));
			} else if (parameterType.equals("Long")) {
				method.invoke(entity, Long.parseLong(val));
			} else if (parameterType.equals("Double")) {
				method.invoke(entity, Double.parseDouble(val));
			} else if (parameterType.equals("BigDecimal")) {
				method.invoke(entity, new BigDecimal(val));
			} else if (parameterType.equals("Date")) {
				method.invoke(entity, new Date(Timestamp.valueOf(val).getTime()));
			} else if (parameterType.equals("Timestamp")) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String v = df.format(Timestamp.valueOf(val));
				method.invoke(entity, Timestamp.valueOf(v));
			}
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	public static <T> T objectToEntry(Object o, Class<?> clzz, Object[] data) {
		T newInstance = null;
		try {
			newInstance = (T) clzz.newInstance();
			Field[] declaredFields = clzz.getDeclaredFields();
			for (int i = 0; i < declaredFields.length; i++) {
				Field field = declaredFields[i];
				field.setAccessible(true);
				field.set(newInstance, data[i]);
				field.setAccessible(false);
			}
		}catch(RuntimeException r){
			throw r;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return newInstance;
	}

	public static String [] getObjectFields(Class<?> obj){
		List<String> sList=new ArrayList<String>();
		Field[] declaredFields = obj.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			sList.add(declaredFields[i].getName());
		}
		String[] array = sList.toArray(new String[sList.size()]);
		return array;
	}
}
