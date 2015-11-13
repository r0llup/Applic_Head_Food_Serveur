<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="no" encoding="utf-8"/>
<xsl:template match="/">
<html>
	<head>
		<title>Applic_Head_Food_Client</title>
	</head>
	<body>
		<h1>Menu '<xsl:value-of select="Menu/@name"/>' '<xsl:value-of select="Menu/@vedetteDuJour"/>'</h1>
			<h2>Entrée '<xsl:value-of select="Menu/Entree/@name"/>' '<xsl:value-of select="Menu/Entree/@type"/>'</h2>
				<h3>Ingrédients</h3>
				<xsl:for-each select="Menu/Entree/Ingredient">
					<ul>
						<li><i><xsl:value-of select="@value"/></i></li>
					</ul>
				</xsl:for-each>
			<h2>Plat '<xsl:value-of select="Menu/Plat/@name"/>' '<xsl:value-of select="Menu/Plat/@type"/>'</h2>
				<h3>Ingrédients</h3>
				<xsl:for-each select="Menu/Plat/Ingredient">
					<ul>
						<li><i><xsl:value-of select="@value"/></i></li>
					</ul>
				</xsl:for-each>
			<h2>Dessert '<xsl:value-of select="Menu/Dessert/@name"/>' '<xsl:value-of select="Menu/Dessert/@type"/>'</h2>
				<h3>Ingrédients</h3>
				<xsl:for-each select="Menu/Dessert/Ingredient">
					<ul>
						<li><i><xsl:value-of select="@value"/></i></li>
					</ul>
				</xsl:for-each>
	</body>
</html>
</xsl:template>
</xsl:stylesheet>