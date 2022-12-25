function drawChart(id, info = []) {
	const data = {
		labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10', 'Tháng 11', 'Tháng 12'],
		datasets: [{
			label: 'Doanh thu',
			data: info,
			fill: false,
			borderColor: 'rgb(75, 192, 192)',
			tension: 0.1
		}]
	};

	const config = {
		type: 'line',
		data: data,
	};
	let ctx = document.getElementById(id).getContext("2d")
	new Chart(ctx, config)
}

function drawChart2(id, info = [], label = []) {
	const data = {
		labels: label,
		datasets: [{
			label: 'Doanh thu',
			data: info,
			borderWidth: 1
		}]
	};
	const config = {
		type: 'bar',
		data: data,
		options: {
			scales: {
				y: {
					beginAtZero: true
				}
			}
		},
	};
	let ctx = document.getElementById(id).getContext("2d")
	new Chart(ctx, config)
}