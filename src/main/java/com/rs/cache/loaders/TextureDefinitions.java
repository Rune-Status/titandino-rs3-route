package com.rs.cache.loaders;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

import com.rs.cache.Cache;
import com.rs.cache.IndexType;
import com.rs.io.InputStream;
import com.rs.utils.Utils;

public class TextureDefinitions {
	
	private static HashMap<Integer, TextureDefinitions> TEXTURE_DEFINITIONS = new HashMap<>();
	
	public int id;
	public boolean bool0;
	public boolean bool1;
	public boolean bool2;
	public int unk0;
	public int unk1;
	public int unk2;
	public int unk3;
	public int unk4;
	public int unk5;
	public int unk6;
	public boolean bool3;
	public boolean bool4;
	public int unk7;
	public boolean bool5;
	public boolean bool6;
	public boolean bool7;
	public int unk8;
	public int unk9;
	public int unk10;
	
	private TextureDefinitions(int id) {
		this.id = id;
	}
	
	public static void parseTextureDefs() {
		TEXTURE_DEFINITIONS.clear();
		
		byte[] data = Cache.STORE.getIndex(IndexType.TEXTURE_DEFINITIONS).getFile(0, 0);
		InputStream stream = new InputStream(data);
		int len = stream.readUnsignedShort();
		
		for (int i = 0;i < len;i++) {
			if (stream.readUnsignedByte() == 1)
				TEXTURE_DEFINITIONS.put(i, new TextureDefinitions(i));
		}
		
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).bool0 = stream.readUnsignedByte() == 0;
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).bool1 = stream.readUnsignedByte() == 1;
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).bool2 = stream.readUnsignedByte() == 1;
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).unk0 = stream.readByte();
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).unk1 = stream.readByte();
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).unk2 = stream.readByte();
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).unk3 = stream.readByte();
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).unk4 = stream.readUnsignedShort();
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).unk5 = stream.readByte();
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).unk6 = stream.readByte();
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).bool3 = stream.readUnsignedByte() == 1;
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).bool4 = stream.readUnsignedByte() == 1;
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).unk7 = stream.readByte();
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).bool5 = stream.readUnsignedByte() == 1;
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).bool6 = stream.readUnsignedByte() == 1;
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).bool7 = stream.readUnsignedByte() == 1;
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).unk8 = stream.readUnsignedByte();
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).unk9 = stream.readInt();
		}
		for (int i = 0;i < len;i++) {
			if (getDefinitions(i) != null)
				getDefinitions(i).unk10 = stream.readUnsignedByte();
		}
	}
	
	public static TextureDefinitions getDefinitions(int id) {
		if (TEXTURE_DEFINITIONS.isEmpty())
			parseTextureDefs();
		return TEXTURE_DEFINITIONS.get(id);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");

		result.append(this.getClass().getName());
		result.append(" {");
		result.append(newLine);

		// determine fields declared in this class only (no fields of
		// superclass)
		Field[] fields = this.getClass().getDeclaredFields();

		// print field names paired with their values
		for (Field field : fields) {
			if (Modifier.isStatic(field.getModifiers()))
				continue;
			result.append("  ");
			try {
				result.append(field.getType().getCanonicalName() + " " + field.getName() + ": ");
				result.append(Utils.getFieldValue(this, field));
			} catch (Throwable ex) {
				System.out.println(ex);
			}
			result.append(newLine);
		}
		result.append("}");

		return result.toString();
	}
}
