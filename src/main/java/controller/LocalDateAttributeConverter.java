/**
 * ajwinters@dmacc.edu - ajwinters
 * CIS175 - Spring 2022
 * Mar 2, 2022
 */
package controller;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date>{
	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {

		return (attribute == null ? null :
			Date.valueOf(attribute));
}
@Override
public LocalDate convertToEntityAttribute(Date dbData)
{
	// TODO Auto-generated method stub
	return (dbData == null ? null :
		dbData.toLocalDate());
}
}
