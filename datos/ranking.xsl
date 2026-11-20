<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">

        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Ranking - El Despertar del Héroe</title>
                <link rel="stylesheet" href="ranking.css"/>
            </head>

            <body>

                <h1>El Despertar del Héroe</h1>
                <h2>Ranking de jugadores</h2>

                <xsl:choose>

                    <xsl:when test="count(ranking/jugador) > 0">

                        <table border="1">
                            <tr>
                                <th>Posición</th>
                                <th>Jugador</th>
                                <th>Puntos</th>
                            </tr>

                            <xsl:for-each select="ranking/jugador">

                                <xsl:sort select="puntos"
                                          data-type="number"
                                          order="descending"/>

                                <tr>
                                    <td><xsl:value-of select="position()"/></td>
                                    <td><xsl:value-of select="nombre"/></td>
                                    <td><xsl:value-of select="puntos"/></td>
                                </tr>

                            </xsl:for-each>

                        </table>

                    </xsl:when>

                    <xsl:otherwise>
                        <p>Todavía no hay jugadores en el ranking.</p>
                    </xsl:otherwise>

                </xsl:choose>

            </body>
        </html>

    </xsl:template>

</xsl:stylesheet>