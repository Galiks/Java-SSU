package com.turchenkov.Spring;

import com.turchenkov.Spring.SecondTask.classForSort.BubbleSort;
import com.turchenkov.Spring.SecondTask.classForSort.SelectSort;
import com.turchenkov.Spring.SecondTask.service.SortService;
import com.turchenkov.Spring.model.Report;
import com.turchenkov.Spring.model.Seller;
import com.turchenkov.Spring.repository.ReportRepository;
import com.turchenkov.Spring.repository.SellerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Application {

//    @RequestMapping("/reports")
//	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
//	}

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");

		Random random = new Random();

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 100000; i++) {
            list.add(random.nextInt(100000));
        }

		BubbleSort bubbleSort = new BubbleSort();

		long startTime = System.currentTimeMillis();
		List<Integer> result = bubbleSort.sort(list);
        long finishTime = System.currentTimeMillis();
        System.out.println("Bubble sort : " + (finishTime-startTime));

        SelectSort selectSort = new SelectSort();
        startTime = System.currentTimeMillis();
        List<Integer> result2 = selectSort.sort(list);
        finishTime = System.currentTimeMillis();
        System.out.println("Quick sort : " + (finishTime-startTime));

        SortService sortService = new SortService();

//		BubbleSort bubbleSort = (BubbleSort)context.getBean("bubble");
//		System.out.println(bubbleSort.sort(list));
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(SellerRepository sellerRepository, ReportRepository reportRepository){
//
//		return (args) -> {
//            Seller seller = new Seller("Pavel", "Turchenkov");
//            Report report = new Report("12.11.2018",
//                    456,
//                    15000,
//                    2000,
//                    13000,
//                    789,
//                    "123");
//			seller.getReports().add(report);
//			report.getSellers().add(seller);
//
//			sellerRepository.save(seller);
//			reportRepository.save(report);
//					};
//	}

}
