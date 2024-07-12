<h1>Seat Management 說明文件</h1>

<h2>環境說明</h2>
<ul>
    <li><strong>資料庫：</strong>MariaDB Server 11.4.2</li>
    <li><strong>Java：</strong>Java 17</li>
    <li><strong>JDK：</strong>JDK 1.8</li>
    <li><strong>框架：</strong>Spring Boot 3.3.1</li>
</ul>

<h2>操作說明</h2>
<ol>
    <li>下載並安裝 MariaDB Server 11.4.2。</li>
    <li>建立資料庫：
        <ul>
            <li>將資料庫結構檔案 <code>.DB/Schema.sql</code> 匯入到 MariaDB 中。</li>
        </ul>
    </li>
    <li>git clone：
        <pre><code>git clone https://github.com/popoan20/esunTest/.git
cd 你的專案</code></pre>
    </li>
    <li>修改資料庫連線配置：
        <ul>
            <li>編輯 <code>src/main/resources/application.properties</code>，將 <code>${yourIpAddress}</code> 替換為你的資料庫IP地址。</li>
        </ul>
        <pre><code>spring.datasource.url=jdbc:mariadb://${yourIpAddress}:3306/seat_management</code></pre>
    </li>
    <li>啟動 Spring Boot 應用程式：
        <ul>
            <li>執行 <code>src/main/java/tw/com/esumTest/seat_management/SeatManagementApplication.java</code>。</li>
        </ul>
    </li>
    <li>在瀏覽器中開啟 <a href="http://localhost:8080/" target="_blank">http://localhost:8080/</a>。</li>
</ol>

<h2>功能介紹</h2>
<ul>
    <li><strong>配置多人座位：</strong>
        <ul>
            <li>可以配置多人的座位，並一次送出。</li>
            <li>若需修改，可在已佔位人員位置上點選，選擇「確定」以刪除該人員位置。完成所有動作後，需「送出」才會完成更新。</li>
        </ul>
    </li>
    <li><strong>刪除人員配置：</strong>
        <ul>
            <li>若只需刪除人員配置，可直接刪除人員，不須送出即完成修改。</li>
        </ul>
    </li>
</ul>
