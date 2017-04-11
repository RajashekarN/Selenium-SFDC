<html>

<body>
<table id='main'>
		<tr class='heading' ><td style="text-align:center;">Failure Report</td></tr>

	<table id='main'>
	<thead>
		<tr class='heading'>
			<th>Test Class Name</th>
			<th>Exception</th>
			<th>Time</th>
		</tr>
		</thead>
		<#list testResultMap as testResultMaps>
		<tr class='content' id="${testResultMaps.testCaseName}">
			<td class='justified'>${testResultMaps.testClassName}</td>
			<td class='justified'>${testResultMaps.reason}</td>
			<td class='justified'>${testResultMaps.executionTime}</td>
		</tr>
		</#list>
</table>
</table>
</body>
</html>