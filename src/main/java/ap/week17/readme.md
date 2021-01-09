<body style="background-color:black;color:lightGray">

# Route Cipher

<p>RouteCipher.java is an implementation of TPS AP Java Lesson 17. It encrypts a string using a block cipher algorithm.</p>

# UML

<table>
<tr>
<th style="border-style:solid;border-width:2px;width:300px;text-align:center;background-color:darkBlue;">RouteCipher</th>
</tr>
<tr><td style="border-style:solid;border-width:0px 2px;font-family:monospace;">-letterBlock: String[][]</td></tr>
<tr><td style="border-style:solid;border-width:0px 2px;font-family:monospace;">-numRows: int</td></tr>
<tr><td style="border-style:solid;border-width:0px 2px 2px 2px;font-family:monospace;">-numColumns: int</td></tr>
<tr><td style="border-style:solid;border-width:0px 2px;font-family:monospace;">+RouteCipher(int, int)</td></tr>
<tr><td style="border-style:solid;border-width:0px 2px;font-family:monospace;">-fillBlock(String)</td></tr>
<tr><td style="border-style:solid;border-width:0px 2px;font-family:monospace;">-encryptBlock(): String</td></tr>
<tr><td style="border-style:solid;border-width:0px 2px;font-family:monospace;">+encryptMessage(String, boolean): String</td></tr>
<tr><td style="border-style:solid;border-width:0px 2px;font-family:monospace;">-fillBlockInColumnOrder(String)</td></tr>
<tr><td style="border-style:solid;border-width:0px 2px;font-family:monospace;">-decryptBlock(): String</td></tr>
<tr><td style="border-style:solid;border-width:0px 2px;font-family:monospace;">+decryptMessage(String): String</td></tr>
<tr><td style="border-style:solid;border-width:0px 2px 2px 2px;font-family:monospace;">+toString(): String</td></tr>

</table>

</body>