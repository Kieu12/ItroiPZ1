<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
<html>
<head>
<h1>Crew</h1>
<title>Crew Details</title>
<style>
                    body {
                    font-family: Arial, sans-serif;
                    line-height: 1.6;
                    margin: 20px;
                    }
                    h1 {
                    color: #333;
                    }
                    .section {
                    margin-bottom: 20px;
                    }
                    .temp-c {
                    border: 1px solid #ccc;
                    padding: 10px;
                    margin-bottom: 10px;
                    margin-inline: 10px;
                    }
                    
                    .section-flex {
                    display: flex;
                    }
                </style>
</head>
<body>
<div class="section">
<xsl:apply-templates select="Crew" />
</div>

<div class="section">
<h2>Tickets</h2>
<div class="section-flex">
<xsl:apply-templates select="Crew/Tickets/Ticket" />
</div>
</div>

</body>
</html>
</xsl:template>
<xsl:template match="Crew">
<div class="temp-c">
<p><strong>Name: </strong> <xsl:value-of select="Name"/></p>
<p><strong>Position: </strong> <xsl:value-of select="Position"/></p>
<p><strong>Flight_Id: </strong> <xsl:value-of select="Flight_Id"/></p>
<p><strong>Id: </strong> <xsl:value-of select="Id"/></p>

</div>
</xsl:template>
<xsl:template match="Ticket">
<div class="temp-c">
<p><strong>Flight_Id: </strong> <xsl:value-of select="Flight_Id"/></p>
<p><strong>Price: </strong> <xsl:value-of select="Price"/></p>
<p><strong>Seat: </strong> <xsl:value-of select="Seat"/></p>
<p><strong>Class: </strong> <xsl:value-of select="Class"/></p>
<p><strong>Id: </strong> <xsl:value-of select="Id"/></p>

</div>
</xsl:template>

</xsl:stylesheet>
