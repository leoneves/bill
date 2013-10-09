Framework bill Seseg

Repositório:

	<repositories>
		<repository>
			<id>bill</id>
			<url>https://raw.github.com/leoneves/bill/mvn-repo/</url>
			<snapshots>
				<enabled>true</enabled>
				<updatePolicy>always</updatePolicy>
			</snapshots>
		</repository>
	</repositories>

Dependência:
${bill.version} pode ser uma propriedade do seu pom, ou você pode substituir pela versão desejada.
	
	<dependency>
		<groupId>br.org.bill</groupId>
		<artifactId>bill</artifactId>
		<version>${bill.version}</version>
	</dependency>
		
