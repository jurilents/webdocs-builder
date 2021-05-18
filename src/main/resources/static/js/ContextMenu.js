export default (function () {
    const PAGE = document.querySelector('.page')

    class ContextMenu {
        constructor(structure) {
            this.element = document.createElement('ul')
            this.element.setAttribute('class', 'context-menu')
            this.element.innerHTML = structure
        }

        insertIn(parentElement) {
            parentElement.insertAdjacentElement('beforeend', this.element)
            this._stopPropagationOnClick()
        }

        showOn(event) {
            this.element.style.top = `${event.clientY}px`
            this.element.style.left = `${event.clientX}px`
            this.element.classList.add('_opened')
        }

        hideOn() {
            document.addEventListener(
                'click',
                (event) => {
                    if (event.button !== 2) {
                        this.element.classList.remove('_opened')
                    }
                },
                false,
            )

            PAGE.addEventListener('scroll', () => {
                this.element.classList.remove('_opened')
            })
        }

        _stopPropagationOnClick() {
            this.element.addEventListener('click', (event) => {
                event.stopPropagation()
            })
        }
    }

    function standardInitialization(ctxMenu, parentElem) {
        const elementsNeededContextMenu = parentElem.querySelectorAll('.iNeedContextMenu')
        ctxMenu.insertIn(parentElem)

        elementsNeededContextMenu.forEach((elem) => {
            elem.addEventListener('contextmenu', (event) => {
                event.preventDefault()
                ctxMenu.showOn(event)
            })
        })

        ctxMenu.hideOn()
    }

    return {
        start: ({ strucrtureOfContextMenu, parentElem }) => {
            if (strucrtureOfContextMenu === 'standard') {
                const documentsContextMenu = new ContextMenu(
                    ` 
                <li class="context-menu__item">
					<img src="img/icons/context-menu/doc.png" alt=""><a href="#>Заповнити шаблон</a>
				</li>	
				<li class="context-menu__item">
					<img src="img/icons/context-menu/multi-redact.png" alt="">Множ. редагування
				</li>
                <li class="context-menu__item">
					<img src="img/icons/context-menu/redact.png" alt=""><a href="#">Редагувати</a>
				</li>
                <li class="context-menu__item">
					<img src="img/icons/context-menu/save.png" alt=""><a href="#" download>Зберегти як...</a>
				</li>
                <li class="context-menu__item">
					<img src="img/icons/context-menu/share.png" alt="">Поділитися
				</li>
                <li class="context-menu__item">
					<img src="img/icons/context-menu/delete.png" alt=""><button type="button">Видалити<button>
				</li>
                `,
                )
                standardInitialization(documentsContextMenu, parentElem)
            } else if (strucrtureOfContextMenu === 'storage') {
                const documentsContextMenu = new ContextMenu(
                    `
                <li class="context-menu__item">
					<img src="img/icons/context-menu/multiple.png" alt="">Множ. заповнення
				</li>
				<li class="context-menu__item">
					<img src="img/icons/context-menu/see-all.png" alt="">Подивитись все
				</li>
                <li class="context-menu__item">
					<img src="img/icons/context-menu/save.png" alt="">Зберегти як...
				</li>
                <li class="context-menu__item">
					<img src="img/icons/context-menu/share.png" alt="">Поділитися
				</li>
                <li class="context-menu__item">
					<img src="img/icons/context-menu/delete.png" alt="">Видалити все
				</li>
                `,
                )
                standardInitialization(documentsContextMenu, parentElem)
            } else if (strucrtureOfContextMenu === 'layout') {
                const documentsContextMenu = new ContextMenu(
                    `
                <li class="context-menu__item">
					<img src="img/icons/context-menu/redact.png" alt="">Редагувати
				</li>
                <li class="context-menu__item">
					<img src="img/icons/context-menu/save.png" alt="">Зберегти як...
				</li>
                <li class="context-menu__item">
					<img src="img/icons/context-menu/share.png" alt="">Поділитися
				</li>
                <li class="context-menu__item">
					<img src="img/icons/context-menu/delete.png" alt="">Видалити
				</li>
                `,
                )
                standardInitialization(documentsContextMenu, parentElem)
            }
        },
    }
})()
