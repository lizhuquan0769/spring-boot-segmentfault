package com.segmentfault.springboot.lession8.controller;

import com.segmentfault.springboot.lession8.jpa.entity.Car;
import com.segmentfault.springboot.lession8.jpa.entity.CreditCard;
import com.segmentfault.springboot.lession8.jpa.entity.Guest;
import com.segmentfault.springboot.lession8.jpa.entity.Store;
import com.segmentfault.springboot.lession8.jpa.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

//    @Autowired
//    private GuestService guestService;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 级联新增：代码逻辑控制，不需要设置CascadeType.PERSIST
     * @param guest
     * @return
     */
    @PostMapping
    @Transactional
    public String add(@RequestBody Guest guest) {

        CreditCard creditCard = guest.getCreditCard();
        entityManager.persist(creditCard);
        creditCard.setGuest(guest);

        List<Car> cars = guest.getCars();
        for (Car car: cars) {
            entityManager.persist(car);
            car.setGuest(guest);
        }

        List<Store> stores = guest.getStores();
        for (Store store: stores) {
            entityManager.persist(store);
            store.setGuests(new ArrayList<>());
            store.getGuests().add(guest);
        }

        entityManager.persist(guest);

        return "add success";
    }

    /**
     * 级联删除：需要配置CascadeType.REMOVE，相应的记录才会被级联删除
     * @param guestId
     * @return
     */
    @DeleteMapping("/{guestId}")
    @Transactional
    public String delete(@PathVariable Long guestId) {

        Guest guest = entityManager.find(Guest.class, guestId);

        entityManager.remove(guest);

        return "delete success";
    }

    /**
     * 更新：主动persist或者退出方法后由aop检查更新并发送update语句
     * @param guestId
     * @return
     */
    @PutMapping("{guestId}")
    @Transactional
    public String update(@PathVariable Long guestId) {

        Guest guest = entityManager.find(Guest.class, guestId);
        guest.setName("更新后的guestName->update");
        guest.getCreditCard().setCardNo("更新后的cardNo->update");

        entityManager.persist(guest);

        return "update success";
    }

    /**
     * 级联合并，相应字段需要配置CascadeType.MERGE，entityManager.merge函数才会生效，guest实体的creditCard字段的修改才会生效
     * @param guestId
     * @return
     */
    @PutMapping("/merge/{guestId}")
    @Transactional
    public String merge(@PathVariable Long guestId) {

        Guest guest = entityManager.find(Guest.class, guestId);
        guest.setName("更新后的guestName->meger");

        CreditCard creditCard = guest.getCreditCard();
        creditCard.setCardNo("更新后的cardNo->meger");

        // 清空所有对象
        entityManager.clear();
        System.out.println();
        entityManager.merge(guest);

        return "merge success";
    }
}
