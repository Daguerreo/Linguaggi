package gui;

import java.net.URL;

public enum CardGraphic {
	// NONE(-1, "None"),
	INCOLOR("incolortemplate.png", "incolormark.png", "incolormark10.png"), AIR(
			"airtemplate.png", "airmark.png", "airmark10.png"), EARTH(
			"earthtemplate.png", "earthmark.png", "earthmark10.png"), FIRE(
			"firetemplate.png", "firemark.png", "firemark10.png"), WATER(
			"watertemplate.png", "watermark.png", "watermark10.png"), LIGHT(
			"lighttemplate.png", "lightmark.png", "lightmark10.png"), DARKNESS(
			"darknesstemplate.png", "darknessmark.png", "darknessmark10.png"), LIFE(
			"lifetemplate.png", "lifemark.png", "lifemark10.png"), DEATH(
			"deathtemplate.png", "deathmark.png", "deathmark10.png"), SPACE(
			"spacetemplate.png", "spacemark.png", "spacemark10.png"), TIME(
			"timetemplate.png", "timemark.png", "timemark10.png"), NOUS(
			"noustemplate.png", "nousmark.png", "nousmark10.png"), VOID(
			"voidtemplate.png", "voidmark.png", "voidmark10.png");

	private final String template;
	private final String mark;
	private final String mark10;
	private final String atk = "atk.png";
	private final String dif = "dif.png";
	private final String rng = "rng.png";

	CardGraphic(String template, String mark, String mark10) {
		this.template = template;
		this.mark = mark;
		this.mark10 = mark10;
	}

	public URL getTemplate() {
		return getClass().getResource("/img/template/" + template);
	}

	public URL getMark() {
		return getClass().getResource("/img/mark/" + mark);
	}

	public URL getMark10() {
		return getClass().getResource("/img/mark/" + mark10);
	}

	public String getPath() {
		return null;
	}

	public URL getAtk() {
		return getClass().getResource("/img/" + atk);
	}

	public URL getDif() {
		return getClass().getResource("/img/" + dif);
	}

	public URL getRng() {
		return getClass().getResource("/img/" + rng);
	}

}
