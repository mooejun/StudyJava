package me.yangjun.modules.base.其他;

import org.junit.Test;

public class BreakDemo {

	@Test
	public void testGoto() {
		labelA: {
			for (int i = 0; i <= 3; i++) {
				labelB: {
					for (int j = 0; j <= 3; j++) {
						System.out.println("i=" + i + ", j=" + j);
						if (i == 2) {
							// 平常使用的“break”就相当于“break labelB”;
							break labelA;
						}
					}
				}
			}
		}
	}
}