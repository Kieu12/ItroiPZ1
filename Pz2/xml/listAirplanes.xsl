<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:airport="http://nure.ua/entity"
                exclude-result-prefixes="airport">

    <!-- Идентификация корневого элемента -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Airplanes Information</title>
            </head>
            <body>
                <h1>Airplanes Information</h1>
                <xsl:apply-templates select="airport:Airplanes/airport:Airplane"/>
            </body>
        </html>
    </xsl:template>


    <xsl:template match="airport:Airplane">
        <div style="border: 1px solid #ccc; padding: 10px; margin-bottom: 20px;">
            <h2><xsl:value-of select="airport:Airplane_Title"/></h2>
            <p><strong>Duration:</strong> <xsl:value-of select="concat(airport:Duration, ' hours')"/></p>
            <p><strong>Destination:</strong> <xsl:value-of select="airport:Destination"/></p>
            <h3>Ticket Information:</h3>
            <xsl:apply-templates select="airport:Ticket"/>
        </div>
    </xsl:template>


    <xsl:template match="airport:Ticket">
        <div style="border: 1px solid #eee; padding: 5px; margin-bottom: 10px;">
            <p><strong>Ticket Number:</strong> <xsl:value-of select="airport:Ticket_Number"/></p>
            <p><strong>Seat Number:</strong> <xsl:value-of select="airport:Seat_Number"/></p>
            <p><strong>Purchase Date:</strong> <xsl:value-of select="airport:Purchase_Date"/></p>
            <h4>Passenger Information:</h4>
            <xsl:apply-templates select="airport:Passenger"/>
        </div>
    </xsl:template>

    <!-- Преобразование информации о зрителе -->
    <xsl:template match="airport:Passenger">
        <p><strong>Name:</strong> <xsl:value-of select="airport:Name"/></p>
        <p><strong>Surname:</strong> <xsl:value-of select="airport:Surname"/></p>
    </xsl:template>
</xsl:stylesheet>
