package com.github.dlozanoc.festapivity.integration.mappers;

import java.time.ZonedDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 	@author dave
 *	Converts a date from a string representation to a {@link java.time.ZonedDateTime} object and vice versa.
 */
public final class StringZonedDateTimeAdapter extends XmlAdapter<String, ZonedDateTime> {

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public ZonedDateTime unmarshal(String v) throws Exception {
		return ZonedDateTime.parse(v);
	}

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public String marshal(ZonedDateTime v) throws Exception {
		return v.toString();
	}

}
