package com.tjcloud.tenpay.api.utils;

import com.tjcloud.core.utils.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

public class MapUtil {

	/**
	 * Map key 排序
	 * @param map map
	 * @return map
	 */
	public static Map<String,String> order(Map<String, String> map){
		SortedMap<String, String> tempMap = new TreeMap<String, String>();
		List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(	map.entrySet());

		Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
				return (o1.getKey()).toString().compareTo(o2.getKey());
			}
		});

		for (int i = 0; i < infoIds.size(); i++) {
			Map.Entry<String, String> item = infoIds.get(i);
			System.out.println(item.getKey() + "      " + item.getValue() + "     " + StringUtils.isNotEmpty(item.getValue()));
			if (StringUtils.isNotEmpty(item.getValue())) {
				tempMap.put(item.getKey(), item.getValue());
			}
		}
		return tempMap;
	}


	/**
	 * 转换对象为map
	 * @param object object
	 * @param ignore ignore
	 * @return map
	 */
	public static Map<String,String> objectToMap(Object object,String... ignore){
		Map<String,String> tempMap = new LinkedHashMap<String, String>();
		for(Field f : getAllFields(object.getClass())){
			if(!f.isAccessible()){
				f.setAccessible(true);
			}
			boolean ig = false;
			if(ignore!=null&&ignore.length>0){
				for(String i : ignore){
					if(i.equals(f.getName())){
						ig = true;
						break;
					}
				}
			}
			if(ig){
				continue;
			}else{
				Object o = null;
				try {
					o = f.get(object);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				tempMap.put(f.getName(), o==null?"":o.toString());
			}
		}
		return tempMap;
	}
	
	/**
	 * jsonString转换对象为map
	 * @param object object
	 * @param ignore ignore
	 * @return map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,String> jsonStringToMap(String jsonStr){
		return JsonUtil.parseObject(jsonStr, Map.class);
	}

	/**
	 * 获取所有Fields,包含父类field
	 * @param clazz clazz
	 * @return list
	 */
	private static List<Field> getAllFields(Class<?> clazz){
		if(!clazz.equals(Object.class)){
			List<Field> fields = new ArrayList<Field>(Arrays.asList(clazz.getDeclaredFields()));
			List<Field> fields2 = getAllFields(clazz.getSuperclass());
			if(fields2!=null){
				fields.addAll(fields2);
			}
			return fields;
		}else{
			return null;
		}
	}

	/**
	 * url 参数串连
	 * @param map map
	 * @param keyLower keyLower
	 * @param valueUrlencode valueUrlencode
	 * @return string
	 */
	public static String mapJoin(Map<String, String> map){
		StringBuilder stringBuilder = new StringBuilder();
		Collection<String> keyset= map.keySet();   
		List<String> list=new ArrayList<String>(keyset);  
		Collections.sort(list);  
		//这种打印出的字符串顺序和微信官网提供的字典序顺序是一致的  
		for(int i=0;i<list.size();i++){  
			System.out.println(list.get(i)+"="+map.get(list.get(i))); 
			if(StringUtils.isNotEmpty(map.get(list.get(i)))){
				stringBuilder.append(list.get(i)).append("=").append(map.get(list.get(i))).append("&");
			}
		}  
		if(stringBuilder.length()>0){
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
		return stringBuilder.toString();
	}

}
