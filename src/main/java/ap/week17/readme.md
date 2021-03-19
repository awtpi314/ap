<body style="background-color:black;color:lightGray">

# Route Cipher

<p>RouteCipher.java is an implementation of TPS AP Java Lesson 17. <br>It encrypts a string using a block cipher algorithm.</p>

### UML

<style>
td {
    border-style: solid;
    border-width: 0px 2px;
    font-family: monospace;
}
</style>

<table>
<tr>
<th style="border-style:solid;border-width:2px;width:300px;text-align:center;background-color:darkBlue;">RouteCipher</th>
</tr>
<tr><td>-letterBlock: String[][]</td></tr>
<tr><td>-numRows: int</td></tr>
<tr><td>-numColumns: int</td></tr>
<tr><td>+RouteCipher(int, int)</td></tr>
<tr><td>-fillBlock(String)</td></tr>
<tr><td>-encryptBlock(): String</td></tr>
<tr><td>+encryptMessage(String, boolean): String</td></tr>
<tr><td>-fillBlockInColumnOrder(String)</td></tr>
<tr><td>-decryptBlock(): String</td></tr>
<tr><td>+decryptMessage(String): String</td></tr>
<tr><td style="border-width:2px 2px 2px 2px;">+toString(): String</td></tr>

</table>

</body>
