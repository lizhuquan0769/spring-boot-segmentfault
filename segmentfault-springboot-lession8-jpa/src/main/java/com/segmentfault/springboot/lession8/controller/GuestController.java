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

    @GetMapping("/{guestId}")
    @Transactional
    public String find(@PathVariable Long guestId) {
        Guest guest = entityManager.find(Guest.class, guestId);

        System.out.println(guest);

        return "get success";
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
     * 级联合并
     * @param guestId
     * @return
     */
    @PutMapping("/merge/{guestId}")
    @Transactional
    public String merge(@PathVariable Long guestId) {

        Guest guest = entityManager.find(Guest.class, guestId);
        CreditCard creditCard = guest.getCreditCard();

        // 清空所有对象
        entityManager.clear();

        guest.setName("更新后的guestName->meger");

        // 合并guest对象，由于guest的creditCard字段配置了CascadeType.MERGE, 所以creditCard的修改也会发送update语句
        creditCard.setCardNo("更新后的cardNo->meger");

        entityManager.merge(guest);

        return "merge success";
    }

    @GetMapping("/detach/{guestId}")
    @Transactional
    public String detect(@PathVariable Long guestId) {

        Guest guest = entityManager.find(Guest.class, guestId);
        CreditCard creditCard = guest.getCreditCard();

        entityManager.detach(guest);

        // 此时guest实体被分离, 方法结束后并不会执行update语句
        guest.setName("更新后的cardNo->detach");

        // 由于guest.creditCard配置了CascadeType.DETACH, 所以guest实体的creditCard字段也会被分离, 方法结束后也不会发送update语句
        creditCard.setCardNo("更新后的cardNo->detach");

        return "detect success";
    }


}
