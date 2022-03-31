package com.cg.farmstore.entities;

public enum Category {
  
	VEGETABLES, FRUITS, DAIRY, GRAINS, DAIRYSOLID;

	public static boolean isCategoryExists(Category c) {
		if (c == Category.VEGETABLES || c == Category.FRUITS || c == Category.DAIRY || c == Category.GRAINS || c == Category.DAIRYSOLID)
			return true;
		else
			return false;
	}

}
